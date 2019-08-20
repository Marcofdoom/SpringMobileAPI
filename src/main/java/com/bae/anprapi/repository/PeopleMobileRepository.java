package com.bae.anprapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.PeopleMobile;

@Repository
public interface PeopleMobileRepository extends JpaRepository<PeopleMobile, String>, PeopleMobileRepositoryCustom {

}