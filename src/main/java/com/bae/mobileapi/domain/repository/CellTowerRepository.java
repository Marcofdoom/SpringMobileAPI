package com.bae.mobileapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.domain.model.CellTower;

@Repository
public interface CellTowerRepository extends JpaRepository<CellTower, Long>{

}