package com.bae.mobileapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.MobileCallRecords;

@Repository
public interface MobileCallRecordsRepository extends JpaRepository<MobileCallRecords, String>{

}