package com.ecommerce.testvirtualcave.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="T_RATES")
@Data
public class TRates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    private Integer price;
    @Column(name = "currency_code")
    private String currencyCode;
}
