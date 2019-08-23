package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;
import com.bae.mobileapi.repository.mobilecallrecords.MobileCallRecordsRepository;

@Service
public class MobileCallRecordsServiceImpl implements MobileCallRecordsService {

	private MobileCallRecordsRepository repository;

	public MobileCallRecordsServiceImpl(MobileCallRecordsRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber) {
		return repository.getMobileCallRecordsDTO(phoneNumber);
	}
}