package com.bae.anprapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.anprapi.model.PeopleMobile;

@Service
public interface MobileService {

	public List<PeopleMobile> getMobile(PeopleMobile peopleMobile);
}
