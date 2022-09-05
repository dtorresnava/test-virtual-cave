package com.ecommerce.testvirtualcave.model.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class TRatesRequest implements Serializable {
    private Long brandId;
    private Long productId;
    private Date startDate;
    private Date endDate;
    private Integer price;
    private String currencyCode;
}
