package com.neuedu.utils;

public class DateInfo {
	private String state;// disabled, enabled, signed, today, signed_today
	private int date;

	public DateInfo() {

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public static DateInfo of(int date, String state) {
		DateInfo dateinfo = new DateInfo();
		dateinfo.setDate(date);
		dateinfo.setState(state);
		return dateinfo;
	}
}
