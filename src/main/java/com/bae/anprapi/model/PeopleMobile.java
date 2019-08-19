package com.bae.anprapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class PeopleMobile {

	@Id
	private String phoneNumber;

	private String forenames;

	private String surname;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String address;

	private String network;

	public PeopleMobile() {

	}

	public PeopleMobile(String phoneNumber, String forenames, String surname, Date dateOfBirth, String address,
			String town, String postcode, String network) {
		this.phoneNumber = phoneNumber;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.network = network;
	}
}