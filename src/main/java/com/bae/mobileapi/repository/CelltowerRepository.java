package com.bae.mobileapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.CellTower;

@Repository
public interface CelltowerRepository extends JpaRepository<CellTower, Long>{

}