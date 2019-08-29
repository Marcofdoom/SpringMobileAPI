package com.bae.mobileapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bae.mobileapi.domain.model.PeopleMobile;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import com.bae.mobileapi.service.MobileCallRecordsService;
import com.bae.mobileapi.service.PeopleMobileService;

@RestController
@RequestMapping("/Mobile")
public class MobileCallRecordsController {

	private MobileCallRecordsService mobileCallRecordsService;
	private PeopleMobileService peopleMobileService;

	@Autowired
	public MobileCallRecordsController(MobileCallRecordsService mobileCallRecordsService,
			PeopleMobileService peopleMobileService) {
		this.mobileCallRecordsService = mobileCallRecordsService;
		this.peopleMobileService = peopleMobileService;
	}

	@GetMapping("/getAssociates")
	public ResponseEntity<List<MobileCallRecordsDTO>> getAssociatesByPhoneNumber(
			@RequestParam(value = "phoneNumber") String phoneNumber) {
		return new ResponseEntity<>(mobileCallRecordsService.findAssociatesByPhoneNumber(phoneNumber), HttpStatus.OK);
	}

	@GetMapping("/getMobile")
	public ResponseEntity<List<PeopleMobile>> getAllPhoneNumbersByIdentity(
			@RequestParam(value = "forenames") String forenames, @RequestParam(value = "surname") String surname,
			@RequestParam(value = "homeAddress", required = false) String homeAddress,
			@RequestParam(value = "dateOfBirth", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {

		PeopleMobile peopleMobile = new PeopleMobile();

		peopleMobile.setForenames(forenames);
		peopleMobile.setSurname(surname);
		peopleMobile.setHomeAddress(homeAddress);
		peopleMobile.setDateOfBirth(dateOfBirth);

		return new ResponseEntity<>(peopleMobileService.findAllPhoneNumbersByIdentity(peopleMobile), HttpStatus.OK);
	}
}