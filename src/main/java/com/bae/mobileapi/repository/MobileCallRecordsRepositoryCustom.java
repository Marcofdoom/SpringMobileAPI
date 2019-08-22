package com.bae.mobileapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;

@Repository
public interface MobileCallRecordsRepositoryCustom {

	List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber);
}