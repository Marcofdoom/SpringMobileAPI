package com.bae.mobileapi.controller;

import com.bae.mobileapi.domain.model.PeopleMobile;
import com.bae.mobileapi.dto.MobileCallRecordsDTO;
import com.bae.mobileapi.service.MobileCallRecordsService;
import com.bae.mobileapi.service.PeopleMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/mobile")
public class MobileCallRecordsController {

    private MobileCallRecordsService mobileCallRecordsService;
    private PeopleMobileService peopleMobileService;

    private int number = 0;

    @Autowired
    public MobileCallRecordsController(MobileCallRecordsService mobileCallRecordsService, PeopleMobileService peopleMobileService) {
        this.mobileCallRecordsService = mobileCallRecordsService;
        this.peopleMobileService = peopleMobileService;
    }

    @GetMapping("/get-associates")
    public ResponseEntity<List<MobileCallRecordsDTO>> getAssociatesByPhoneNumber(
            @RequestParam(value = "phone-number") String phoneNumber) {
        return new ResponseEntity<>(mobileCallRecordsService.findAssociatesByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/get-mobile")
    public ResponseEntity<List<PeopleMobile>> getAllPhoneNumbersByIdentity(@RequestParam(value = "forenames") String forenames,
                                                                           @RequestParam(value = "surname") String surname,
                                                                           @RequestParam(value = "home-address") String homeAddress,
                                                                           @RequestParam(value = "date-of-birth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth) {

        PeopleMobile peopleMobile = new PeopleMobile();

        peopleMobile.setForenames(forenames);
        peopleMobile.setSurname(surname);
        peopleMobile.setHomeAddress(homeAddress);
        peopleMobile.setDateOfBirth(dateOfBirth);

        return new ResponseEntity<>(peopleMobileService.findAllPhoneNumbersByIdentity(peopleMobile), HttpStatus.OK);
    }

    @PostMapping("post-data")
    public void postData() {
        for (int i = 0; i < 10000; i++) {
            number++;
            String phoneNumber = String.format("%09d", number);
            peopleMobileService.savePeopleMobile(new PeopleMobile(phoneNumber, new Date(), "f", "h", "n", "s"));
        }
    }
}