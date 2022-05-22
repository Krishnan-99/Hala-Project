package com.example.hala_project.Model;

public class ContactDetails {
    String name;
    String role;
    String company;

    public String getAddress() {
        return Address;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEducation() {
        return Education;
    }

    public String getDOB() {
        return DOB;
    }

    public String getCountry() {
        return Country;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setCountry(String country) {
        Country = country;
    }

    String Address;
    String EmailID;
    String PhoneNumber;
    String Education;
    String DOB;
    String Country;

    int image;


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
