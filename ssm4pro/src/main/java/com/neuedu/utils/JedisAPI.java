package com.neuedu.utils;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
 * 即将全面改写，主要修改部分是将异常向上抛出
 */
public class JedisAPI {

    private static final Logger LOG = LoggerFactory.getLogger(JedisAPI.class);

    private volatile static JedisAPI jedisApi;

    /**
     * 保存多个连接源
     */
    private static Map<String, JedisPool> poolMap = new HashMap<String, JedisPool>();

    private JedisAPI() {
    }

    /**
     * @Description: jedisPool 池
     * @Param: [ip, port]
     * @return: redis.clients.jedis.JedisPool
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    private static JedisPool getPool(String ip, int port) {

        try {
            String key = ip + ":" + port;
            JedisPool pool = null;
            if (!poolMap.containsKey(key)) {
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxIdle(10);
                config.setMaxTotal(50);
                //  在获取连接的时候检查有效性, 默认false
                config.setTestOnBorrow(true);
                //  在空闲时检查有效性, 默认false
                config.setTestOnReturn(true);
                pool = new JedisPool(config, ip, port, 60);
                poolMap.put(key, pool);
            } else {
                pool = poolMap.get(key);
            }
            return pool;
        } catch (Exception e) {
            LOG.error("init jedis pool failed ! " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * @Description: 线程安全单例模式
     * @Param: []
     * @return: JedisApi
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public static JedisAPI getRedisApi() {

        if (jedisApi == null) {
            synchronized (JedisAPI.class) {
                if (jedisApi == null) {
                    jedisApi = new JedisAPI();
                }
            }
        }
        return jedisApi;
    }

    /**
     * @Description: 获取一个jedis连接
     * @Param: [ip, port]
     * @return: redis.clients.jedis.Jedis
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public Jedis getRedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        while (jedis == null && count <= 3) {
            try {
                jedis = getPool(ip, port).getResource();
            } catch (Exception e) {
                LOG.error("get redis failed ! " + e.getMessage(), e);
                count++;
            }
        }
        return jedis;
    }

    /**
     * @Description: 释放jedis到jedisPool中
     * @Param: [jedis, ip, port]
     * @return: void
     * @Author: imdalai
     * @Date: 2018/1/15
     */
    public void closeRedis(Jedis jedis) {

        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {
                LOG.error("colse jedis failed ! " + e.getMessage(), e);
            }
        }
    }
}