package com.bae.mobileapi.domain.dao;

import com.bae.mobileapi.domain.model.PeopleMobile;
import com.bae.mobileapi.domain.repository.PeopleMobileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PeopleMobileDAOTest {

    @Mock
    private PeopleMobileRepository peopleMobileRepository;

    @InjectMocks
    private PeopleMobileDAO peopleMobileDAO;

    @Test
    void findAllPhoneNumbersByIdentity() {

        // state
        final String forenames = "forenames";
        final String surname = "surname";
        final String homeAddress = "homeAddress";
        final Date dateOfBirth = new Date();

        final PeopleMobile peopleMobile1 = new PeopleMobile();
        peopleMobile1.setForenames(forenames);
        peopleMobile1.setSurname(surname);
        peopleMobile1.setHomeAddress(homeAddress);
        peopleMobile1.setDateOfBirth(dateOfBirth);

        final PeopleMobile peopleMobile2 = new PeopleMobile();
        peopleMobile2.setForenames(forenames);
        peopleMobile2.setSurname(surname);
        peopleMobile2.setHomeAddress(homeAddress);
        peopleMobile2.setDateOfBirth(dateOfBirth);

        Example<PeopleMobile> probe = Example.of(peopleMobile1, ExampleMatcher.matching().withIgnoreCase());

        final List<PeopleMobile> peopleMobiles = Arrays.asList(peopleMobile1, peopleMobile2);

        when(peopleMobileRepository.findAll(probe)).thenReturn(peopleMobiles);

        // test
        List<PeopleMobile> returnedPeopleMobiles = peopleMobileDAO.findAllPhoneNumbersByIdentity(probe);

        // verify
        verify(peopleMobileRepository, times(1)).findAll(probe);
        verifyNoMoreInteractions(peopleMobileRepository);

        // assert
        assertIterableEquals(peopleMobiles, returnedPeopleMobiles);
    }
}