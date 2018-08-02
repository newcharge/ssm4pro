package com.neuedu.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static String ObjectToJson(Object data) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(data);
	}

	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonData, beanType);
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
		return mapper.readValue(jsonData, javaType);
	}
}
