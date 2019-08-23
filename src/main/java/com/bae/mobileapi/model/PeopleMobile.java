package com.bae.mobileapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PeopleMobile {

	@Id
	private String phoneNumber;

	private String forenames;

	private String surname;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String homeAddress;

	private String network;

	@OneToMany(mappedBy = "callerMsisdn")
	private List<MobileCallRecords> callRecords;

	public PeopleMobile() {

	}

	public PeopleMobile(String phoneNumber, String forenames, String surname, Date dateOfBirth, String homeAddress,
			String town, String postcode, String network) {
		this.phoneNumber = phoneNumber;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.network = network;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
}