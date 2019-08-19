package com.bae.anprapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.CellTower;

@Repository
public interface CelltowerRepository extends JpaRepository<CellTower, Long>{

}