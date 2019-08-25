package com.bae.mobileapi.domain.dao;

import com.bae.mobileapi.domain.repository.MobileCallRecordsRepository;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MobileCallRecordsDAOTest {

    @Mock
    private MobileCallRecordsRepository mobileCallRecordsRepository;

    @InjectMocks
    private MobileCallRecordsDAO mobileCallRecordsDAO;

    private static String phoneNumber;

    private static List<MobileCallRecordsDTO> mobileCallRecords;

    @BeforeAll
    static void initAll() {
        phoneNumber = "phoneNumber";
        final String forenames = "forenames";
        final String surname = "surname";
        final String address = "address";
        final Date dateOfBirth = new Date();
        final Date timestamp = new Date();

        final MobileCallRecordsDTO mobileCallRecords1 = new MobileCallRecordsDTO(forenames, surname, address, dateOfBirth, timestamp);
        final MobileCallRecordsDTO mobileCallRecords2 = new MobileCallRecordsDTO(forenames, surname, address, dateOfBirth, timestamp);
        mobileCallRecords = Arrays.asList(mobileCallRecords1, mobileCallRecords2);
    }

    @Test
    void findAssociatesCalledByPhoneNumber() {

        // state
        when(mobileCallRecordsRepository.findAssociatesCalledByPhoneNumber(phoneNumber)).thenReturn(mobileCallRecords);

        // test
        List<MobileCallRecordsDTO> returnedMobileCallRecordsDTO = mobileCallRecordsDAO.findAssociatesCalledByPhoneNumber(phoneNumber);

        // verify
        verify(mobileCallRecordsRepository, times(1)).findAssociatesCalledByPhoneNumber(phoneNumber);
        verifyNoMoreInteractions(mobileCallRecordsRepository);

        // assert
        assertIterableEquals(mobileCallRecords, returnedMobileCallRecordsDTO);
    }

    @Test
    void findAssociatesReceivedByPhoneNumber() {
        // state
        when(mobileCallRecordsRepository.findAssociatesReceivedByPhoneNumber(phoneNumber)).thenReturn(mobileCallRecords);

        // test
        List<MobileCallRecordsDTO> returnedMobileCallRecordsDTO = mobileCallRecordsDAO.findAssociatesReceivedByPhoneNumber(phoneNumber);

        // verify
        verify(mobileCallRecordsRepository, times(1)).findAssociatesReceivedByPhoneNumber(phoneNumber);
        verifyNoMoreInteractions(mobileCallRecordsRepository);

        // assert
        assertIterableEquals(mobileCallRecords, returnedMobileCallRecordsDTO);
    }
}