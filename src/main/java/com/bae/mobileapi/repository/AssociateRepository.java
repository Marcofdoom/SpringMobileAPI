package com.bae.mobileapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.AssociateReceiver;

@Repository
public class AssociateRepository {

	private static final BeanPropertyRowMapper<AssociateReceiver> ROW_MAPPER = new BeanPropertyRowMapper<>(
			AssociateReceiver.class);

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public Iterable<AssociateReceiver> findAssociateReceivers() {
		return jdbcTemplate.query("SELECT * FROM associates", ROW_MAPPER);
	}

}
