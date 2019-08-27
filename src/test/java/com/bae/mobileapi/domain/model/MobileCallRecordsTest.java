package com.bae.mobileapi.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MobileCallRecordsTest {

    private static MobileCallRecords mobileCallRecords;
    private static Date timestamp;
    private static PeopleMobile peopleMobile1;
    private static PeopleMobile peopleMobile2;

    @BeforeAll
    static void initAll() {
        timestamp = new Date();
        peopleMobile1 = new PeopleMobile("phoneNumber", new Date(), "forenames", "homeAddress", "network", "surname");
        peopleMobile2 = new PeopleMobile("phoneNumber", new Date(), "forenames", "homeAddress", "network", "surname");
        mobileCallRecords = new MobileCallRecords(1L, peopleMobile1, 2L, peopleMobile2, 3L, timestamp);
    }

    @Test
    void getId() {
        assertEquals(1L, (long) mobileCallRecords.getId());
    }

    @Test
    void setId() {
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setId(5L);
        assertTrue(mobileCallRecords.getId() == 5L);
    }

    @Test
    void getCallerMsisdn() {
        assertEquals(peopleMobile1, mobileCallRecords.getCallerMsisdn());
    }

    @Test
    void setCallerMsisdn() {
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setCallerMsisdn(peopleMobile1);
        assertTrue(mobileCallRecords.getCallerMsisdn().equals(peopleMobile1));
    }

    @Test
    void getCallerCellTower() {
        assertEquals(2L, (long) mobileCallRecords.getCallerCellTower());
    }

    @Test
    void setCallerCellTower() {
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setCallerCellTower(15L);
        assertTrue(mobileCallRecords.getCallerCellTower() == 15L);
    }

    @Test
    void getReceiverMsisdn() {
        assertEquals(peopleMobile2, mobileCallRecords.getReceiverMsisdn());
    }

    @Test
    void setReceiverMsisdn() {
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setReceiverMsisdn(peopleMobile1);
        assertTrue(mobileCallRecords.getReceiverMsisdn().equals(peopleMobile1));
    }

    @Test
    void getReceiverCellTower() {
        assertEquals(3L, (long) mobileCallRecords.getReceiverCellTower());
    }

    @Test
    void setReceiverCellTower() {
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setReceiverCellTower(10L);
        assertTrue(mobileCallRecords.getReceiverCellTower() == 10L);
    }

    @Test
    void getTimestamp() {
        assertEquals(timestamp, mobileCallRecords.getTimestamp());
    }

    @Test
    void setTimestamp() {
        Date date = new Date();
        MobileCallRecords mobileCallRecords = new MobileCallRecords();
        mobileCallRecords.setTimestamp(date);
        assertTrue(mobileCallRecords.getTimestamp().equals(date));
    }
}