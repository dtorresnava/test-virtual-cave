package com.ecommerce.testvirtualcave.model.response;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.model.Result;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class TRatesListResponse extends Result {
    private List<TRates> tRatesList;
}
