package com.ecommerce.testvirtualcave.service;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.domain.service.TRatesDomainService;
import com.ecommerce.testvirtualcave.model.Result;
import com.ecommerce.testvirtualcave.model.request.TRatesRequest;
import com.ecommerce.testvirtualcave.model.response.TRatesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TRatesService extends TRatesDomainService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public TRates insertTrates(TRatesRequest request) {
        return setTrates(objectMapper.convertValue(request, TRates.class));
    }

    public Result delete(Long id) {
        try {
            deleteTRates(id);
            return Result.builder()
                    .result("00")
                    .messageDescription("Registro actualizado con exito")
                    .build();
        } catch (EmptyResultDataAccessException e) {
            return Result.builder()
                    .result("01")
                    .messageDescription(e.getLocalizedMessage())
                    .build();
        }

    }

    public TRatesResponse updateTRates(Long id, TRatesRequest request) {
        Optional<TRates> tRatesOptional = findById(id);
        TRatesResponse response = new TRatesResponse();

        if(!tRatesOptional.isEmpty()) {
            TRates tRates = objectMapper.convertValue(request, TRates.class);
            tRates.setId(id);
            response.setTRates(setTrates(tRates));
            response.setResult("00");
            return response;
        } else {
            response.setResult("01");
            response.setMessageDescription("Error al actualizar el registro");
            return response;
        }
    }
}
