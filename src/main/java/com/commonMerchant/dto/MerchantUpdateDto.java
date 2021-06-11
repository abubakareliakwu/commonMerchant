package com.commonMerchant.dto;

import lombok.Data;

@Data
public class MerchantUpdateDto {

    public Integer phoneNumber;
    public String password;
    public String confirmPassword;
    public Long MerchantTypeID;

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
        return MerchantTypeID;
    }

    public void setMerchantTypeID(Long merchantTypeID) {
        MerchantTypeID = merchantTypeID;
    }
}
