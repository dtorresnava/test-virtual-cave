package com.ecommerce.testvirtualcave.domain.repository;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TRatesRepository extends JpaRepository<TRates, Long> {
}
