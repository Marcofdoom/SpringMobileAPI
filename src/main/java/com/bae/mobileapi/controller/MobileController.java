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
import com.bae.mobileapi.service.MobileService;

@RestController
@RequestMapping("/Mobile")
public class MobileController {


	private MobileService service;
	
	public MobileController() {
		
	}
	
	@Autowired
	public MobileController(MobileService service) {
		this.service = service;
	}
	
	@GetMapping("/getMobile")
	public ResponseEntity<Object> getMobile(
			@RequestParam(value = "forenames", required = false) String forenames,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "homeAddress", required = false) String homeAddress,
			@RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {
	
		PeopleMobile peopleMobileEntity = new PeopleMobile();
		
		peopleMobileEntity.setForenames(forenames);
		peopleMobileEntity.setSurname(surname);
		peopleMobileEntity.setAddress(homeAddress);
		peopleMobileEntity.setDateOfBirth(dateOfBirth);
		
		return new ResponseEntity<>(service.getMobile(peopleMobileEntity), HttpStatus.OK);
	}
}