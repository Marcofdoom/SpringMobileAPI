package com.bae.mobileapi.domain.repository;

import com.bae.mobileapi.domain.model.PeopleMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleMobileRepository extends JpaRepository<PeopleMobile, String>, QueryByExampleExecutor<PeopleMobile> {

}