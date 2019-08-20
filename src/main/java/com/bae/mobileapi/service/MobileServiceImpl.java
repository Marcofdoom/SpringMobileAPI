package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.PeopleMobile;
import com.bae.mobileapi.repository.PeopleMobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

	private PeopleMobileRepository peopleMobileRepository;

	@Autowired
	public MobileServiceImpl(PeopleMobileRepository peopleMobileRepository) {
		this.peopleMobileRepository = peopleMobileRepository;
	}

	@Override
	public List<PeopleMobile> getMobile(PeopleMobile peopleMobile) {

		return peopleMobileRepository.findMobile(peopleMobile.getForenames(), peopleMobile.getSurname(),
				peopleMobile.getAddress(), peopleMobile.getDateOfBirth());
	}
}