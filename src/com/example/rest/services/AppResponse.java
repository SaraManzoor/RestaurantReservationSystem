package com.example.rest.services;

public class AppResponse {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	private String status = SUCCESS; //Using success as default
	private String msg;
	private Object payload;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}