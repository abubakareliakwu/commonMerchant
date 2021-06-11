package com.commonMerchant.repository;

import com.commonMerchant.domain.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Long> {

    Merchant getMerchantByPhoneNumber(Integer phoneNumber);
}
