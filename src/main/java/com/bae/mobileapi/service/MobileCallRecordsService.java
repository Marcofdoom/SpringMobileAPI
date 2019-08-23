package com.bae.mobileapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;

@Service
public interface MobileCallRecordsService {

	List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber);
}