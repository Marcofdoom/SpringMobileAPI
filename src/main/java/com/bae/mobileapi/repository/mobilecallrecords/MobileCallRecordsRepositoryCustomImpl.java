package com.bae.mobileapi.repository.mobilecallrecords;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bae.mobileapi.model.DTO.MobileCallRecordsDTO;
import com.bae.mobileapi.util.CallType;

@Repository
public class MobileCallRecordsRepositoryCustomImpl implements MobileCallRecordsRepositoryCustom {

	private static final String CALLS_CALLED_QUERY = "SELECT NEW com.bae.mobileapi.model.DTO.MobileCallRecordsDTO("
			+ "p.receiverMsisdn.forenames, p.receiverMsisdn.surname, p.receiverMsisdn.homeAddress,"
			+ "p.receiverMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p where "
			+ "p.callerMsisdn.phoneNumber = :phoneNumber";

	private static final String CALLS_RECEIVED_QUERY = "SELECT NEW com.bae.mobileapi.model.DTO.MobileCallRecordsDTO("
			+ "p.callerMsisdn.forenames, p.callerMsisdn.surname, p.callerMsisdn.homeAddress,"
			+ "p.callerMsisdn.dateOfBirth, p.timestamp) FROM MobileCallRecords p where "
			+ "p.receiverMsisdn.phoneNumber = :phoneNumber";

	private EntityManager entityManager;

	@Autowired
	public MobileCallRecordsRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MobileCallRecordsDTO> getMobileCallRecordsDTO(String phoneNumber) {

		TypedQuery<MobileCallRecordsDTO> queryCaller = entityManager
				.createQuery(CALLS_CALLED_QUERY, MobileCallRecordsDTO.class).setParameter("phoneNumber", phoneNumber);

		TypedQuery<MobileCallRecordsDTO> queryReceiver = entityManager
				.createQuery(CALLS_RECEIVED_QUERY, MobileCallRecordsDTO.class).setParameter("phoneNumber", phoneNumber);

		List<MobileCallRecordsDTO> queryCallers = queryCaller.getResultList();
		List<MobileCallRecordsDTO> queryReceivers = queryReceiver.getResultList();

		queryCallers.stream().forEach(i -> i.setCallType(CallType.CALLED));
		queryReceivers.stream().forEach(i -> i.setCallType(CallType.RECEIVED));

		queryCallers.addAll(queryReceivers);

		return queryCallers;
	}
}