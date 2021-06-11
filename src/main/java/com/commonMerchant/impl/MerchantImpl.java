package com.commonMerchant.impl;

import com.commonMerchant.domain.Merchant;
import com.commonMerchant.domain.MerchantType;
import com.commonMerchant.dto.MerchantDto;
import com.commonMerchant.dto.MerchantUpdateDto;
import com.commonMerchant.enums.ResponseObject;
import com.commonMerchant.enums.ResponseStatus;
import com.commonMerchant.repository.MerchantRepository;
import com.commonMerchant.repository.MerchantTypeRepository;
import com.commonMerchant.service.MerchantService;
import com.commonMerchant.utils.Constants;
import com.commonMerchant.utils.EntityNotFoundException;
import com.commonMerchant.utils.ResponseDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MerchantImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MerchantTypeRepository merchantTypeRepository;

    @Autowired
    PasswordValidationImpl passwordValidation;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public ResponseEntity save(MerchantDto merchantDto) {

        Map<Object, Object> jsonResponse = new HashMap();

        if (merchantDto.getPassword() != null && merchantDto.getPassword().length() > 8) {
            if (!merchantDto.getPassword().equals(merchantDto.getConfirmPassword())) {
                return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.PASSWORD_NOT_MATCH.getDescription(), jsonResponse);
            }

            String pwdValid = passwordValidation.validatePassword(merchantDto.getPassword());
            if (pwdValid != null) {
                return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), pwdValid, jsonResponse);
            }

            MerchantType merchantType = merchantTypeRepository.findById(merchantDto.getMerchantTypeID()).orElseThrow(()
                    -> new EntityNotFoundException("Merchant Type not available kindly use the appropriate merchant type"));

            Merchant merchant = new Merchant();
            merchant.setFirstName(merchantDto.getFirstName());
            merchant.setLastName(merchantDto.getLastName());
            merchant.setDob(merchantDto.getDob());
            merchant.setPassword(bcryptEncoder.encode(merchantDto.getPassword()));
            merchant.setConfirmPassword(bcryptEncoder.encode(merchantDto.getConfirmPassword()));
            merchant.setEmail(merchantDto.getEmail());
            merchant.setPhoneNumber(merchantDto.getPhoneNumber());
            merchant.setMerchantType(merchantType);
            merchant.setSex(merchantDto.getSex());

            try {
                jsonResponse.put(Constants.CREATED, merchantRepository.save(merchant));
                return new ResponseObject().returnResponseBody("200", "Record successfully created",merchant);
            } catch (DataIntegrityViolationException exception) {
                return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exception.getRootCause().getLocalizedMessage(),"");
            }
        }else {
            return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.PASSWORD_NOT_COMPLETE.getDescription(), jsonResponse);

        }


    }

    @Override
    public ResponseEntity update(MerchantUpdateDto merchantUpdateDto) {

        Map<Object, Object> jsonResponse = new HashMap();

        Merchant merchant = merchantRepository.getMerchantByPhoneNumber(merchantUpdateDto.getPhoneNumber());

        if(merchant.getId() != null){

            MerchantType merchantType = merchantTypeRepository.findById(merchantUpdateDto.getMerchantTypeID()).orElseThrow(()
                    -> new EntityNotFoundException("Merchant Type not available kindly use the appropriate merchant type"));

            merchant.setPassword(merchantUpdateDto.getPassword());
            merchant.setConfirmPassword(merchantUpdateDto.getConfirmPassword());
            merchant.setMerchantType(merchantType);

            try {
                jsonResponse.put(Constants.UPDATED, merchantRepository.save(merchant));
                return new ResponseObject().returnResponseBody("200", "Record successfully updated",merchant);
            } catch (DataIntegrityViolationException exception) {
                return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exception.getRootCause().getLocalizedMessage(),"");
            }

        }else {
            return new ResponseObject().returnResponseBody("202", "Record not found","");
        }
    }


}
