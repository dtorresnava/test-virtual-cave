package com.ecommerce.testvirtualcave.model.response;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.model.Result;
import lombok.Data;

@Data
public class TRatesResponse extends Result {
    private TRates tRates;
}
