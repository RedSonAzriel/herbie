package com.herbie.sc.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "client")
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    @NotBlank
    String employee;
    @Column
    String emailAddress;
    @Column
    String city;
    @Column
    String country;
    @Column
    String phoneNumber;
    @Column
    String spokeToDc;
    @Column
    String dcPartner;
    @Column
    String relationshipStrength;
    @Column
    String companyName;
    @Column
    String contactMethod;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpokeToDc() {
        return spokeToDc;
    }

    public void setSpokeToDc(String spokeToDc) {
        this.spokeToDc = spokeToDc;
    }

    public String getDcPartner() {
        return dcPartner;
    }

    public void setDcPartner(String dcPartner) {
        this.dcPartner = dcPartner;
    }

    public String getRelationshipStrength() {
        return relationshipStrength;
    }

    public void setRelationshipStrength(String relationshipStrength) {
        this.relationshipStrength = relationshipStrength;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactType) {
        this.contactMethod = contactType;
    }
}
