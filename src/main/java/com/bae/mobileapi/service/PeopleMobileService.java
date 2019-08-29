package com.bae.mobileapi.service;

import com.bae.mobileapi.domain.dao.PeopleMobileDAO;
import com.bae.mobileapi.domain.model.PeopleMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleMobileService {

	private PeopleMobileDAO peopleMobileDAO;

	@Autowired
	public PeopleMobileService(PeopleMobileDAO peopleMobileDAO) {
		this.peopleMobileDAO = peopleMobileDAO;
	}

	public List<PeopleMobile> findAllPhoneNumbersByIdentity(PeopleMobile probe) {
		return peopleMobileDAO
				.findAllPhoneNumbersByIdentity(Example.of(probe, ExampleMatcher.matching().withIgnoreCase()));
	}
}