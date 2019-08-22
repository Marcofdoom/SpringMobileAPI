package com.bae.mobileapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;
import com.bae.mobileapi.util.CallType;

@Repository
public class MobileCallRecordsRepositoryCustomImpl implements MobileCallRecordsRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public MobileCallRecordsRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber) {

		TypedQuery<MobileCallRecordsDTO> queryCaller = entityManager
				.createQuery("SELECT NEW com.bae.mobileapi.model.DTO.MobileCallRecordsDTO("
						+ "p.receiverMsisdn.forenames, p.receiverMsisdn.surname, p.receiverMsisdn.address,"
						+ "p.receiverMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p where "
						+ "p.callerMsisdn.phoneNumber = :phoneNumber", MobileCallRecordsDTO.class)
				.setParameter("phoneNumber", phoneNumber);

		TypedQuery<MobileCallRecordsDTO> queryReceiver = entityManager
				.createQuery("SELECT NEW com.bae.mobileapi.model.DTO.MobileCallRecordsDTO("
						+ "p.callerMsisdn.forenames, p.callerMsisdn.surname, p.callerMsisdn.address,"
						+ "p.callerMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p where "
						+ "p.receiverMsisdn.phoneNumber = :phoneNumber", MobileCallRecordsDTO.class)
				.setParameter("phoneNumber", phoneNumber);

		List<MobileCallRecordsDTO> queryCallers = queryCaller.getResultList();
		List<MobileCallRecordsDTO> queryReceivers = queryReceiver.getResultList();

		queryCallers.stream().forEach(i -> i.setCallType(CallType.CALLED));
		queryReceivers.stream().forEach(i -> i.setCallType(CallType.RECEIVED));

		queryCallers.addAll(queryReceivers);

		return queryCallers;
	}
}