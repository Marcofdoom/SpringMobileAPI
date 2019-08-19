package com.bae.anprapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.MobileCallRecords;

@Repository
public interface MobileCallRecordsRepository extends JpaRepository<MobileCallRecords, String>{

}