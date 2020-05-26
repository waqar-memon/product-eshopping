package com.systems.customerservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customers")
public class CustomerDocument {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String landline;
    private String country;
    private String city;
    private String address;
//    @DBRef
//    private List<CustomerContactDocument> contactDetails;
//    private List<CustomerAddressDocument> addressDetails;

    public CustomerDocument(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //    public List<CustomerContactDocument> getContactDetails() {
//        return contactDetails;
//    }
//
//    public void setContactDetails(List<CustomerContactDocument> contactDetails) {
//        this.contactDetails = contactDetails;
//    }
//
//    public List<CustomerAddressDocument> getAddressDetails() {
//        return addressDetails;
//    }
//
//    public void setAddressDetails(List<CustomerAddressDocument> addressDetails) {
//        this.addressDetails = addressDetails;
//    }
}
