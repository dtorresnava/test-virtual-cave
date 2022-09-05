package com.ecommerce.testvirtualcave.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(name = "brand_id")
    private Long brandId;
}
