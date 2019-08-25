package com.bae.mobileapi.domain.model;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Indexed
@Table(indexes = {
        @Index(name = "IDX_DATEOFBIRTH_FORENAMES_HOMEADDRESS_SURNAME", columnList = "dateOfBirth,forenames,homeAddress,surname")})
public class PeopleMobile {

    @Id
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String forenames;

    private String homeAddress;

    private String network;

    private String surname;

    @OneToMany(mappedBy = "callerMsisdn")
    private List<MobileCallRecords> callRecords;

    public PeopleMobile() {

    }

    public PeopleMobile(String phoneNumber, Date dateOfBirth, String forenames, String homeAddress, String network, String surname) {
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.forenames = forenames;
        this.homeAddress = homeAddress;
        this.network = network;
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getForenames() {
        return forenames;
    }

    public void setForenames(String forenames) {
        this.forenames = forenames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}