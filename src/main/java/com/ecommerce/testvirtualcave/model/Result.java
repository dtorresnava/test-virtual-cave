package com.ecommerce.testvirtualcave.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    private String result;
    private String messageDescription;
}
