package com.commonMerchant.repository;

import com.commonMerchant.domain.MerchantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTypeRepository  extends JpaRepository<MerchantType,Long> {
}
