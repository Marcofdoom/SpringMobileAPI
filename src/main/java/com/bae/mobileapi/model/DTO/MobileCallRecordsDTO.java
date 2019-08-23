package com.bae.mobileapi.model.DTO;

import java.util.Date;

import com.bae.mobileapi.util.CallType;

public class MobileCallRecordsDTO {

	private String forenames;

	private String surname;

	private String address;

	private Date dateOfBirth;

	private Date timestamp;

	private CallType callType;

	public MobileCallRecordsDTO(String forenames, String surname, String address, Date dateOfBirth, Date timestamp) {
		this.forenames = forenames;
		this.surname = surname;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.timestamp = timestamp;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public CallType getCallType() {
		return callType;
	}

	public void setCallType(CallType callType) {
		this.callType = callType;
	}
}