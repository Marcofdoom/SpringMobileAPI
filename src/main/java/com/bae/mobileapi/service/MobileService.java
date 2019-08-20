package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.PeopleMobile;

@Service
public interface MobileService {

	public List<PeopleMobile> getMobile(PeopleMobile peopleMobile);
}
