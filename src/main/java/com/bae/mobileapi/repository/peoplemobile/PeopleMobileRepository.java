package com.bae.mobileapi.repository.peoplemobile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.PeopleMobile;

@Repository
public interface PeopleMobileRepository extends JpaRepository<PeopleMobile, String>, QueryByExampleExecutor<PeopleMobile> {

}