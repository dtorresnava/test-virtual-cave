package com.ecommerce.testvirtualcave.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TRatesFilterRequest implements Serializable {
    private String date;
    private Long brandId;
    private Long productId;
}
