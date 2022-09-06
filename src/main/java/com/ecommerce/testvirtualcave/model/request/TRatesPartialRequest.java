package com.ecommerce.testvirtualcave.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TRatesPartialRequest implements Serializable {
    private Integer price;
}
