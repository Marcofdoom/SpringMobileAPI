package com.bae.mobileapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bae.mobileapi.model.PeopleMobile;
import com.bae.mobileapi.service.PeopleMobileService;

@RestController
@RequestMapping("/Mobile")
public class PeopleMobileController {

	private PeopleMobileService service;

	public PeopleMobileController() {

	}

	@Autowired
	public PeopleMobileController(PeopleMobileService service) {
		this.service = service;
	}

	@GetMapping("/getMobile")
	public ResponseEntity<Object> getMobile(@RequestParam(value = "forenames", required = false) String forenames,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "homeAddress", required = false) String homeAddress,
			@RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {

		PeopleMobile peopleMobile = new PeopleMobile();

		peopleMobile.setForenames(forenames);
		peopleMobile.setSurname(surname);
		peopleMobile.setAddress(homeAddress);
		peopleMobile.setDateOfBirth(dateOfBirth);

		return new ResponseEntity<>(service.findMobile(peopleMobile), HttpStatus.OK);
	}
}