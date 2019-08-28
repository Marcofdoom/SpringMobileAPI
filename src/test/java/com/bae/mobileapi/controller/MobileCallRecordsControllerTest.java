package com.bae.mobileapi.controller;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bae.mobileapi.domain.model.PeopleMobile;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import com.bae.mobileapi.service.MobileCallRecordsService;
import com.bae.mobileapi.service.PeopleMobileService;

@ExtendWith(MockitoExtension.class)
public class MobileCallRecordsControllerTest {

	@Mock
	private MobileCallRecordsService mobileCallRecordsService;

	@Mock
	private PeopleMobileService peopleMobileService;

	@InjectMocks
	private MobileCallRecordsController mobileCallRecordsController;

	@Test
	void getAssociatesByPhoneNumber() {

		// state
		final String phoneNumber = "phoneNumber";
		final List<MobileCallRecordsDTO> mobileCallrecordsDTOs = new ArrayList<MobileCallRecordsDTO>();
		final MobileCallRecordsDTO mobileCallRecordsDTO = new MobileCallRecordsDTO("", "", "", new Date(), new Date());

		mobileCallrecordsDTOs.add(mobileCallRecordsDTO);

		when(mobileCallRecordsService.findAssociatesByPhoneNumber(phoneNumber)).thenReturn(mobileCallrecordsDTOs);

		// test
		ResponseEntity<List<MobileCallRecordsDTO>> returnedResponse = mobileCallRecordsController
				.getAssociatesByPhoneNumber(phoneNumber);

		// verify
		verify(mobileCallRecordsService, times(1)).findAssociatesByPhoneNumber(phoneNumber);
		verifyNoMoreInteractions(mobileCallRecordsService);

		// assert
		assertIterableEquals(mobileCallrecordsDTOs, returnedResponse.getBody());
	}

	@Test
	void getAllPhoneNumbersByIdentity() {

		// state
		final List<PeopleMobile> peopleMobiles = new ArrayList<PeopleMobile>();

		when(peopleMobileService.findAllPhoneNumbersByIdentity(Mockito.any(PeopleMobile.class)))
				.thenReturn(peopleMobiles);

		// test
		ResponseEntity<List<PeopleMobile>> returnedResponse = mobileCallRecordsController
				.getAllPhoneNumbersByIdentity("forenames", "surname", "homeAddress", new Date());

		// verify
		verify(peopleMobileService, times(1)).findAllPhoneNumbersByIdentity(Mockito.any(PeopleMobile.class));
		verifyNoMoreInteractions(peopleMobileService);

		// assert
		assertIterableEquals(peopleMobiles, returnedResponse.getBody());
	}
}