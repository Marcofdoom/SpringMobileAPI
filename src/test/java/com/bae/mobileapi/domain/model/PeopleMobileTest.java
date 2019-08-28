package com.bae.mobileapi.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PeopleMobileTest {

	private static PeopleMobile peopleMobile;
	private static Date date;

	@BeforeAll
	static void initAll() {
		date = new Date();
		peopleMobile = new PeopleMobile("phoneNumber", date, "forenames", "homeAddress", "network", "surname");
	}

	@Test
	void getPhoneNumber() {
		assertThat(peopleMobile.getPhoneNumber().equalsIgnoreCase("phoneNumber"));
	}

	@Test
	void setPhoneNumber() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setPhoneNumber("phoneNumber");
		assertThat(peopleMobile.getPhoneNumber().equals("phoneNumber"));
	}

	@Test
	void getForenames() {
		assertThat(peopleMobile.getForenames().equalsIgnoreCase("forenames"));
	}

	@Test
	void setForenames() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setForenames("fornames");
		assertThat(peopleMobile.getForenames().equals("fornames"));
	}

	@Test
	void getSurname() {
		assertThat(peopleMobile.getSurname().equals("surname"));
	}

	@Test
	void setSurname() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setSurname("surname");
		assertThat(peopleMobile.getSurname().equals("surname"));
	}

	@Test
	void getDateOfBirth() {
		assertThat(peopleMobile.getDateOfBirth() == date);
	}

	@Test
	void setDateOfBirth() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setDateOfBirth(date);
		assertThat(peopleMobile.getDateOfBirth() == date);
	}

	@Test
	void getHomeAddress() {
		assertThat(peopleMobile.getHomeAddress().equalsIgnoreCase("homeAddress"));
	}

	@Test
	void setHomeAddress() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setHomeAddress("homeAddress");
		assertThat(peopleMobile.getHomeAddress().equals("homeAddress"));
	}

	@Test
	void getNetwork() {
		assertThat(peopleMobile.getNetwork().equals("network"));
	}

	@Test
	void setNetwork() {
		PeopleMobile peopleMobile = new PeopleMobile();
		peopleMobile.setNetwork("network");
		assertThat(peopleMobile.getNetwork().equals("network"));
	}
}