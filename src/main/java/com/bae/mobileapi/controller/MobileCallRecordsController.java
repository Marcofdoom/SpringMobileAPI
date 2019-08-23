package com.bae.mobileapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bae.mobileapi.service.MobileCallRecordsService;

@RestController
@RequestMapping("/Mobile")
public class MobileCallRecordsController {

	private MobileCallRecordsService service;

	public MobileCallRecordsController() {

	}

	@Autowired
	public MobileCallRecordsController(MobileCallRecordsService service) {
		this.service = service;
	}

	@GetMapping("/getAssociates")
	public ResponseEntity<Object> getRecordsDTO(
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
		return new ResponseEntity<>(service.getMobileCallRecordsDTO(phoneNumber), HttpStatus.OK);
	}
}