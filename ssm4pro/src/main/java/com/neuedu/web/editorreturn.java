package com.neuedu.web;

public class editorreturn {
	private	int code;
	private	String message;
	private	Layui_Data_json data;
	public editorreturn() {
		// TODO Auto-generated constructor stub
		data=new Layui_Data_json();
	}
	public editorreturn(String filename, String filepath) {
		// TODO Auto-generated constructor stub
	}
	public void responsejson(){
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
	public Layui_Data_json getData() {
		return data;
	}
	public void setData(String filepath) {
		data.setSrc(filepath);
	}
}
