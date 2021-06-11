package com.commonMerchant.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MerchantDto {

    public String firstName;
    public String lastName;
    public String sex;
    public String email;
    public Date dob;
    public Integer phoneNumber;
    public String password;
    public String confirmPassword;
    public Long merchantTypeID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getMerchantTypeID() {
        return merchantTypeID;
    }

    public void setMerchantTypeID(Long merchantTypeID) {
        this.merchantTypeID = merchantTypeID;
    }
}
