package com.commonMerchant.controller;

import com.commonMerchant.domain.Merchant;
import com.commonMerchant.dto.MerchantDto;
import com.commonMerchant.dto.MerchantUpdateDto;
import com.commonMerchant.impl.MerchantImpl;
import com.commonMerchant.repository.MerchantRepository;
import com.commonMerchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @Resource
    MerchantRepository merchantRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Merchant> findAll(final Pageable pageable) throws EntityNotFoundException {
        return merchantRepository.findAll(pageable);
    }

    @RequestMapping(value = "/createMerchant", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody MerchantDto merchantDto) throws Exception {
        return merchantService.save(merchantDto);
    }

    @RequestMapping(value = "/updateMerchant", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody MerchantUpdateDto merchantUpdateDto) throws Exception {
        return merchantService.update(merchantUpdateDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Merchant findById(@PathVariable String id) throws EntityNotFoundException {
        return merchantRepository.findById(Long.valueOf(id)).get();
    }


}
