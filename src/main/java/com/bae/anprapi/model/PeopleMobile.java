package com.bae.anprapi.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class PeopleMobile {

	@Id
	private long phoneNumber;
	
	private String forenames;
	
	private String surname;
	
	private long dateOfBirth;
	
	private String Address;
	
	private String town;
	
	private String postcode;
	
	private String network;

	public PeopleMobile() {
		super();
	}

	public PeopleMobile(long phoneNumber, String forenames, String surname, long dateOfBirth, String address,
			String town, String postcode, String network) {
		super();
		this.phoneNumber = phoneNumber;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		Address = address;
		this.town = town;
		this.postcode = postcode;
		this.network = network;
	}
}
