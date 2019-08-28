package com.bae.mobileapi.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bae.mobileapi.domain.dao.PeopleMobileDAO;
import com.bae.mobileapi.domain.model.PeopleMobile;

@ExtendWith(MockitoExtension.class)
public class PeopleMobileServiceTest {

	@InjectMocks
	private PeopleMobileService peopleMobileService;

	@Mock
	private PeopleMobileDAO peopleMobileDAO;

	@Test
	void findAllPhoneNumbersByIdentityTest() {

		// STATE
		List<PeopleMobile> peopleMobiles = new ArrayList<PeopleMobile>();

		when(peopleMobileDAO.findAllPhoneNumbersByIdentity(Mockito.any())).thenReturn(peopleMobiles);

		// TEST
		List<PeopleMobile> returnedList = peopleMobileService.findAllPhoneNumbersByIdentity(new PeopleMobile());

		// VERIFY
		verify(peopleMobileDAO, times(1)).findAllPhoneNumbersByIdentity(Mockito.any());
		verifyNoMoreInteractions(peopleMobileDAO);

		// ASSERT
		assertIterableEquals(peopleMobiles, returnedList);
	}
}