package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;
import com.bae.mobileapi.repository.MobileCallRecordsRepository;

@Service
public class AssociatesServiceImpl implements AssociatesService {

	private MobileCallRecordsRepository repository;

	public AssociatesServiceImpl(MobileCallRecordsRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber) {
		return repository.getMobileCallRecordsDTO(phoneNumber);
	}
}