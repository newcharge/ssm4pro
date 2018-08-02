package com.neuedu.web;

public class responsejson {

	private	int code;
	private	String message;
	private	String data;
	public responsejson() {
		// TODO Auto-generated constructor stub
	}
	public responsejson(String filename, String filepath) {
		// TODO Auto-generated constructor stub
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
