package com.commonMerchant.service;

import com.commonMerchant.dto.MerchantDto;
import com.commonMerchant.dto.MerchantUpdateDto;
import org.springframework.http.ResponseEntity;

public interface MerchantService {

    ResponseEntity save(MerchantDto merchantDto);
    ResponseEntity update(MerchantUpdateDto merchantUpdateDto);


}
