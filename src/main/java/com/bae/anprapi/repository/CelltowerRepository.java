package com.bae.anprapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.Celltower;

@Repository
public interface CelltowerRepository extends JpaRepository<Celltower, Long>{

}
