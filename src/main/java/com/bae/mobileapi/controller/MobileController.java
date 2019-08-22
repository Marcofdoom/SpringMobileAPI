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
import com.bae.mobileapi.service.AssociatesService;
import com.bae.mobileapi.service.MobileService;

@RestController
@RequestMapping("/Mobile")
public class MobileController {

	private MobileService mobileService;

	private AssociatesService associatesService;

	public MobileController() {

	}

	@Autowired
	public MobileController(MobileService mobileService, AssociatesService associatesService) {
		this.mobileService = mobileService;
		this.associatesService = associatesService;
	}

	@GetMapping("/getMobile")
	public ResponseEntity<Object> getMobile(@RequestParam(value = "forenames", required = false) String forenames,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "homeAddress", required = false) String homeAddress,
			@RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {

		PeopleMobile peopleMobileEntity = new PeopleMobile();

		peopleMobileEntity.setForenames(forenames);
		peopleMobileEntity.setSurname(surname);
		peopleMobileEntity.setAddress(homeAddress);
		peopleMobileEntity.setDateOfBirth(dateOfBirth);

		return new ResponseEntity<>(mobileService.getMobile(peopleMobileEntity), HttpStatus.OK);
	}

	@GetMapping("/getAssociates")
	public ResponseEntity<Object> getRecordsDTO(
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
		return new ResponseEntity<>(associatesService.getMobileCallRecordsDTO(phoneNumber), HttpStatus.OK);
	}
}