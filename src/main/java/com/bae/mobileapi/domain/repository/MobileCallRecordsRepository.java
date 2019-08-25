package com.bae.mobileapi.domain.repository;


import com.bae.mobileapi.domain.model.MobileCallRecords;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileCallRecordsRepository extends JpaRepository<MobileCallRecords, String> {

    @Query("SELECT NEW com.bae.mobileapi.dto.MobileCallRecordsDTO("
            + "p.receiverMsisdn.forenames, p.receiverMsisdn.surname, p.receiverMsisdn.homeAddress,"
            + "p.receiverMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p WHERE "
            + "p.callerMsisdn.phoneNumber = ?1")
    List<MobileCallRecordsDTO> findAssociatesCalledByPhoneNumber(String phoneNumber);

    @Query("SELECT NEW com.bae.mobileapi.dto.MobileCallRecordsDTO("
            + "p.callerMsisdn.forenames, p.callerMsisdn.surname, p.callerMsisdn.homeAddress,"
            + "p.callerMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p WHERE "
            + "p.receiverMsisdn.phoneNumber = ?1")
    List<MobileCallRecordsDTO> findAssociatesReceivedByPhoneNumber(String phoneNumber);
}