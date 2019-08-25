package com.bae.mobileapi.domain.dao;

import com.bae.mobileapi.domain.repository.MobileCallRecordsRepository;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MobileCallRecordsDAO {

    private MobileCallRecordsRepository mobileCallRecordsRepository;

    @Autowired
    public MobileCallRecordsDAO(MobileCallRecordsRepository mobileCallRecordsRepository) {
        this.mobileCallRecordsRepository = mobileCallRecordsRepository;
    }

    public List<MobileCallRecordsDTO> findAssociatesCalledByPhoneNumber(String phoneNumber) {
        return mobileCallRecordsRepository.findAssociatesCalledByPhoneNumber(phoneNumber);
    }

    public List<MobileCallRecordsDTO> findAssociatesReceivedByPhoneNumber(String phoneNumber) {
        return mobileCallRecordsRepository.findAssociatesReceivedByPhoneNumber(phoneNumber);
    }
}