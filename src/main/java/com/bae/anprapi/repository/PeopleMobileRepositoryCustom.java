package com.bae.anprapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.PeopleMobile;

@Repository
public interface PeopleMobileRepositoryCustom {
	public List<PeopleMobile> findMobile(String forenames, String surname, String homeAddress, Date dateOfBirth);

}
