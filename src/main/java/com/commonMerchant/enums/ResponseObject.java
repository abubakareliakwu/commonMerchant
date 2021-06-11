package com.commonMerchant.enums;

import com.commonMerchant.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {

    public final String PASSWORD = "*****";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<?> returnResponseBody(Object code, String message,Object data) {
        Map<String, Object> jsonResponse = new HashMap();
        jsonResponse.put(Constants.STATUS, code);
        jsonResponse.put(Constants.MESSAGE, message);
        jsonResponse.put("data", data);
        logger.info("RESPONSE===> " + jsonResponse.toString());
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }



}
