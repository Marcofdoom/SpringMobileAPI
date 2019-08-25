//package com.bae.mobileapi.domain.model;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class CellTowerTest {
//
//    private static CellTower cellTower;
//
//    @BeforeAll
//    static void initAll() {
//        cellTower = new CellTower(1L, "operator", "type", 1.0F, 1.0F);
//    }
//
//    @Test
//    void getCellTowerId() {
//        assertEquals(1L, (long) cellTower.getCellTowerId());
//    }
//
//    @Test
//    void setCellTower() {
//        cellTower.setCellTower(2L);
//        assertTrue(cellTower.getCellTowerId() == 2);
//    }
//
//    @Test
//    void getOperator() {
//        assertEquals("operator", cellTower.getOperator());
//    }
//
//    @Test
//    void setOperator() {
//        cellTower.setOperator("new operator");
//        assertTrue(cellTower.getCellTowerId().equals("new operator"));
//    }
//
//    @Test
//    void getType() {
//        assertEquals("type", cellTower.getType());
//    }
//
//    @Test
//    void setType() {
//        cellTower.setOperator("new type");
//        assertTrue(cellTower.getCellTowerId().equals("new type"));
//    }
//
//    @Test
//    void getLatitude() {
//        assertEquals(1.0F, (float) cellTower.getLatitude());
//    }
//
//    @Test
//    void setLatitude() {
//        cellTower.setLatitude(2.0F);
//        assertTrue(cellTower.getLatitude() == 2.0F);
//    }
//
//    @Test
//    void getLongitude() {
//        assertEquals(1.0F, (float) cellTower.getLongitude());
//    }
//
//    @Test
//    void setLongitude() {
//        cellTower.setLongitude(2.0F);
//        assertTrue(cellTower.getLongitude() == 2.0F);
//    }
//}