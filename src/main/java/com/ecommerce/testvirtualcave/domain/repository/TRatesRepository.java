package com.ecommerce.testvirtualcave.domain.repository;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TRatesRepository extends JpaRepository<TRates, Long> {
    List<TRates> findByBrandIdAndProductIdAndStartDateLessThanAndEndDateGreaterThan(Long brandId, Long productId, Date startDate, Date endDate);
    List<TRates> findByBrandIdAndProductId(Long brandId, Long productId);
    List<TRates> findByBrandIdAndProductIdAndStartDateLessThanEqual(Long brandId, Long productId, Date date);
    List<TRates> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long brandId, Long productId, Date startDate, Date endDate);
}
