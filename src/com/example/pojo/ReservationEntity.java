package com.example.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationEntity {

	private int id;
	private String confirmationNum;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private String address;
	private int partySize;
	private Date reservationTime;
	private int reservationTable;
	private String reservationStatus = "Waiting";
	
	
	
	public ReservationEntity() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConfirmationNum() {
		return confirmationNum;
	}
	public void setConfirmationNum(String confirmationNum) {
		this.confirmationNum = confirmationNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPartySize() {
		return partySize;
	}
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	public int getReservationTable() {
		return reservationTable;
	}
	public void setReservationTable(int reservationTable) {
		this.reservationTable = reservationTable;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Override
	public String toString() {
		return "ReservationEntity [id=" + id + ", confirmationNum="
				+ confirmationNum + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", gender=" + gender + ", address="
				+ address + ", partySize=" + partySize + ", reservationTime="
				+ reservationTime + ", reservationTable=" + reservationTable
				+ ", reservationStatus=" + reservationStatus + "]";
	}
	
}