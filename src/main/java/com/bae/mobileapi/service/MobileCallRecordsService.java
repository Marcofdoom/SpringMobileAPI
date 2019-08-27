package com.bae.mobileapi.service;

import java.util.List;

import com.bae.mobileapi.domain.dao.MobileCallRecordsDAO;
import com.bae.mobileapi.dto.CallType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.mobileapi.dto.MobileCallRecordsDTO;

@Service
public class MobileCallRecordsService {

    private MobileCallRecordsDAO mobileCallRecordsDAO;

    @Autowired
    public MobileCallRecordsService(MobileCallRecordsDAO mobileCallRecordsDAO) {
        this.mobileCallRecordsDAO = mobileCallRecordsDAO;
    }

    public List<MobileCallRecordsDTO> findAssociatesByPhoneNumber(String phoneNumber) {

        List<MobileCallRecordsDTO> callers = mobileCallRecordsDAO.findAssociatesCalledByPhoneNumber(phoneNumber);
        callers.forEach(i -> i.setCallType(CallType.CALLED));

        List<MobileCallRecordsDTO> receivers = mobileCallRecordsDAO.findAssociatesReceivedByPhoneNumber(phoneNumber);
        receivers.forEach(i -> i.setCallType(CallType.RECEIVED));

        callers.addAll(receivers);
        return callers;
    }
}