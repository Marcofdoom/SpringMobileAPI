package com.bae.mobileapi.repository.celltower;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.CellTower;

@Repository
public interface CellTowerRepository extends JpaRepository<CellTower, Long>{

}