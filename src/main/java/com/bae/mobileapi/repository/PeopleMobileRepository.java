package com.bae.mobileapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.PeopleMobile;

@Repository
public interface PeopleMobileRepository extends JpaRepository<PeopleMobile, String>, PeopleMobileRepositoryCustom {

}