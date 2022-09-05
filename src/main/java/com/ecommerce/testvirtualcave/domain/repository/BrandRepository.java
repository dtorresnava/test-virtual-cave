package com.ecommerce.testvirtualcave.domain.repository;

import com.ecommerce.testvirtualcave.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
