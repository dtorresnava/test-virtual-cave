package com.ecommerce.testvirtualcave.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TRatesRequest implements Serializable {
    private Long brandId;
    private Long productId;
    private String startDate;
    private String endDate;
    private Integer price;
    private String currencyCode;
}
