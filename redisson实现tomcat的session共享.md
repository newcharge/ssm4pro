#### redisson 整合方式——与 Tomcat vX.X 整合的步骤

##### Tomcat的准备工作

1. 在tomcat安装路径下的lib文件夹中放入"redisson-all.jar"和"redisson-tomcat-X.jar"，以确保tomcat能正常使用redisson提供的类。
	下载地址:
	redisson本体↓
	JDK 1.8+适用
	[redisson-all-3.6.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-all&v=3.6.4&e=jar)
	JDK 1.6+适用
	[redisson-all-2.11.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-all&v=2.11.4&e=jar)
	
	JDK 1.8+下的Tomcat支持组件↓
	Tomcat 6.x适用
	[redisson-tomcat-6-3.6.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-6&v=3.6.4&e=jar)
	Tomcat 7.x适用
	[redisson-tomcat-7-3.6.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-7&v=3.6.4&e=jar)
	Tomcat 8.x适用
	[redisson-tomcat-8-3.6.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-8&v=3.6.4&e=jar)
	Tomcat 9.x适用
	[redisson-tomcat-9-3.6.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-9&v=3.6.4&e=jar)
	
	JDK 1.6+下的Tomcat支持组件↓
	Tomcat 6.x适用
	[redisson-tomcat-6-2.11.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-6&v=2.11.4&e=jar)
	Tomcat 7.x适用
	[redisson-tomcat-7-2.11.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-7&v=2.11.4&e=jar)
	Tomcat 8.x适用
	[redisson-tomcat-8-2.11.4.jar](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=org.redisson&a=redisson-tomcat-8&v=2.11.4&e=jar)
	
	
2. 修改tomcat的context.xml，加入这一段代码：
	<Manager className="org.redisson.tomcat.RedissonSessionManager"
				configPath="${catalina.base}/conf/redisson.conf"
				readMode="REDIS"
				updateMode="DEFAULT" />
	其中:
	RedissonSessionManager负责管理Tomcat会话,
	configPath是redisson配置文件路径,
	readMode设定session属性获取的方式，默认从tomcat获取，这里设定成从redis中获取,
	updateMode设定更新session的方式，每次setAttribute将更新一次session.
	更多详情可以查阅文档:
	[redisson文档 第三方框架整合](https://github.com/redisson/redisson/wiki/14.-%E7%AC%AC%E4%B8%89%E6%96%B9%E6%A1%86%E6%9E%B6%E6%95%B4%E5%90%88)
	
3. 在对应的redisson配置文件路径下，建立一个相应的配置文件redisson.conf，在里面只用写上以下内容：
	{
	"singleServerConfig":{
		"address": "redis://192.168.52.134:6379",
		}
	}
	这里采用json格式的配置方式，以上配置指定了redisson访问的redis服务地址，以及模式（单节点模式），更多配置信息可以查阅文档：
	[redisson文档 配置方法](https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95)

在集群中的每台Tomcat上进行上述配置，Tomcat部分的准备工作完成。

##### Redis的准备工作

1. redis可以架设在与Tomcat不同的位置，这里采用的是单节点模式，只有一个redis服务监听，为此需要修改配置文件，使其允许外部访问（如果已经将绑定设定为0.0.0.0，就不需要再另行修改）。
2. 由于指定了配置文件，在运行redis-server时需要加上路参数，指明配置文件的路径。
	$ sudo ./redis-server /etc/redis/redis.conf  ←这里写什么取决于配置文件的路径
3. 测试时，在启动redis-cli时加上IP和端口
	$ ./redis-cli ./redis-cli -h 192.168.52.134 -p 6379 ←IP地址和端口号同样取决于架设redis的位置

在指定的非127.0.0.1的套接字下 ping PONG 成功即可确认Redis部分的准备工作完成

##### Nginx的准备工作

如果之前配置了ip-hash，去ip-hash即可，只需要去掉 "ip_hash;" 一行。

##### 系统测试时的启动顺序

nginx -> redis -> tomcat
