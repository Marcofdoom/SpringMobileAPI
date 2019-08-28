package com.bae.mobileapi.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bae.mobileapi.domain.dao.MobileCallRecordsDAO;
import com.bae.mobileapi.dto.CallType;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;

@ExtendWith(MockitoExtension.class)
public class MobileCallRecordsServiceTest {

	private static List<MobileCallRecordsDTO> mobileCallRecordsDTO1;
	private static List<MobileCallRecordsDTO> mobileCallRecordsDTO2;
	private static List<MobileCallRecordsDTO> combinedList;

	@InjectMocks
	private MobileCallRecordsService mobileCallRecordsService;

	@Mock
	private MobileCallRecordsDAO mobileCallRecordsDAO;

	@BeforeAll
	static void initAll() {
		MobileCallRecordsDTO mCRDTO1 = new MobileCallRecordsDTO("", "", "", new Date(), new Date());
		MobileCallRecordsDTO mCRDTO2 = new MobileCallRecordsDTO("", "", "", new Date(), new Date());

		mobileCallRecordsDTO1 = new ArrayList<MobileCallRecordsDTO>();
		mobileCallRecordsDTO1.add(mCRDTO1);

		mobileCallRecordsDTO2 = new ArrayList<MobileCallRecordsDTO>();
		mobileCallRecordsDTO2.add(mCRDTO2);

		combinedList = new ArrayList<MobileCallRecordsDTO>();
		combinedList.addAll(mobileCallRecordsDTO1);
		combinedList.addAll(mobileCallRecordsDTO2);
	}

	@Test
	void findAssociatesByPhoneNumber() {

		// STATE
		when(mobileCallRecordsDAO.findAssociatesCalledByPhoneNumber(Mockito.anyString()))
				.thenReturn(mobileCallRecordsDTO1);
		when(mobileCallRecordsDAO.findAssociatesReceivedByPhoneNumber(Mockito.anyString()))
				.thenReturn(mobileCallRecordsDTO2);

		// TEST
		List<MobileCallRecordsDTO> returnedRecords = mobileCallRecordsService
				.findAssociatesByPhoneNumber(Mockito.anyString());

		// verify
		verify(mobileCallRecordsDAO, times(1)).findAssociatesCalledByPhoneNumber(Mockito.anyString());
		verify(mobileCallRecordsDAO, times(1)).findAssociatesReceivedByPhoneNumber(Mockito.anyString());
		verifyNoMoreInteractions(mobileCallRecordsDAO);

		// ASSERT
		assertIterableEquals(combinedList, returnedRecords);
	}

	@Test
	void callerTypeAdded() {

		// STATE
		when(mobileCallRecordsDAO.findAssociatesCalledByPhoneNumber(Mockito.anyString()))
				.thenReturn(mobileCallRecordsDTO1);
		when(mobileCallRecordsDAO.findAssociatesReceivedByPhoneNumber(Mockito.anyString()))
				.thenReturn(new ArrayList<MobileCallRecordsDTO>());

		// TEST
		List<MobileCallRecordsDTO> returnedRecords = mobileCallRecordsService
				.findAssociatesByPhoneNumber(Mockito.anyString());

		// ASSERT
		Assert.assertThat(returnedRecords,
				(Every.everyItem(HasPropertyWithValue.hasProperty("callType", Is.is(CallType.CALLED)))));
	}

	@Test
	void receiverTypeAdded() {

		// STATE
		when(mobileCallRecordsDAO.findAssociatesCalledByPhoneNumber(Mockito.anyString()))
				.thenReturn(new ArrayList<MobileCallRecordsDTO>());
		when(mobileCallRecordsDAO.findAssociatesReceivedByPhoneNumber(Mockito.anyString()))
				.thenReturn(mobileCallRecordsDTO2);

		// TEST
		List<MobileCallRecordsDTO> returnedRecords = mobileCallRecordsService
				.findAssociatesByPhoneNumber(Mockito.anyString());

		// ASSERT
		Assert.assertThat(returnedRecords,
				(Every.everyItem(HasPropertyWithValue.hasProperty("callType", Is.is(CallType.RECEIVED)))));
	}
}