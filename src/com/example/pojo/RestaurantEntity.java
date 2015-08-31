package com.example.pojo;

import java.util.Date;

public class RestaurantEntity {

	private int restID;
	private String restName;
	private String restPhone;
	private String restEmail;
	private String restAddress;
	private String restTimings = "12:00 - 9:00 PM";
	private int autoAssign;
	
	
	public RestaurantEntity() {
		super();
	}
	public RestaurantEntity(int restID, String restName, String restPhone,
			String restEmail, String restAddress, String restTimings,
			int autoAssign) {
		super();
		this.restID = restID;
		this.restName = restName;
		this.restPhone = restPhone;
		this.restEmail = restEmail;
		this.restAddress = restAddress;
		this.restTimings = restTimings;
		this.autoAssign = autoAssign;
	}
	public int getRestID() {
		return restID;
	}
	public void setRestID(int restID) {
		this.restID = restID;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestPhone() {
		return restPhone;
	}
	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone;
	}
	public String getRestEmail() {
		return restEmail;
	}
	public void setRestEmail(String restEmail) {
		this.restEmail = restEmail;
	}
	public String getRestAddress() {
		return restAddress;
	}
	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	public String getRestTimings() {
		return restTimings;
	}
	public void setRestTimings(String restTimings) {
		this.restTimings = restTimings;
	}
	public int getAutoAssign() {
		return autoAssign;
	}
	public void setAutoAssign(int autoAssign) {
		this.autoAssign = autoAssign;
	}
	@Override
	public String toString() {
		return "RestaurantEntity [restID=" + restID + ", restName=" + restName
				+ ", restPhone=" + restPhone + ", restEmail=" + restEmail
				+ ", restAddress=" + restAddress + ", restTimings="
				+ restTimings + ", autoAssign=" + autoAssign + "]";
	}
	
	
}
