package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.PeopleMobile;

@Service
public interface PeopleMobileService {

	public List<PeopleMobile> findMobile(PeopleMobile peopleMobile);
}