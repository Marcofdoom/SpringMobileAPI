package com.bae.mobileapi.domain.dao;

import com.bae.mobileapi.domain.model.PeopleMobile;
import com.bae.mobileapi.domain.repository.PeopleMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleMobileDAO {

	private PeopleMobileRepository peopleMobileRepository;

	@Autowired
	public PeopleMobileDAO(PeopleMobileRepository peopleMobileRepository) {
		this.peopleMobileRepository = peopleMobileRepository;
	}

	public List<PeopleMobile> findAllPhoneNumbersByIdentity(Example<PeopleMobile> peopleMobile) {
		return peopleMobileRepository.findAll(peopleMobile);
	}
}