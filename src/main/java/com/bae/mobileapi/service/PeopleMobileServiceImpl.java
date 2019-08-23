package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.PeopleMobile;
import com.bae.mobileapi.repository.peoplemobile.PeopleMobileRepository;

@Service
public class PeopleMobileServiceImpl implements PeopleMobileService {

	private PeopleMobileRepository repository;

	@Autowired
	public PeopleMobileServiceImpl(PeopleMobileRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<PeopleMobile> findMobile(PeopleMobile probe) {
		return repository.findAll(Example.of(probe, ExampleMatcher.matchingAll().withIgnoreCase()));
	}
}