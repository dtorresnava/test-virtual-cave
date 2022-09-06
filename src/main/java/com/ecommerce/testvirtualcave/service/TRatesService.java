package com.ecommerce.testvirtualcave.service;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.domain.service.TRatesDomainService;
import com.ecommerce.testvirtualcave.model.Result;
import com.ecommerce.testvirtualcave.model.request.TRatesFilterRequest;
import com.ecommerce.testvirtualcave.model.request.TRatesRequest;
import com.ecommerce.testvirtualcave.model.response.TRatesListResponse;
import com.ecommerce.testvirtualcave.model.response.TRatesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class TRatesService extends TRatesDomainService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public TRates insertTrates(TRatesRequest request) throws ParseException {
        TRates tRates = objectMapper.convertValue(request, TRates.class);
        tRates.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getStartDate()));
        tRates.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getEndDate()));
        return setTrates(tRates);
    }

    public Result delete(Long id) {
        Result result = new Result();
        try {
            deleteTRates(id);
            result.setResult("00");
            return result;
        } catch (EmptyResultDataAccessException e) {
            result.setResult("01");
            result.setMessageDescription(e.getLocalizedMessage());
            return result;
        }

    }

    public TRatesResponse updateTRates(Long id, TRatesRequest request) {
        Optional<TRates> tRatesOptional = findById(id);
        TRatesResponse response = new TRatesResponse();

        if (!tRatesOptional.isEmpty()) {
            TRates tRates = objectMapper.convertValue(request, TRates.class);
            tRates.setId(id);
            response.setTRates(setTrates(tRates));
            response.setResult("00");
        } else {
            response.setResult("01");
            response.setMessageDescription("Error al actualizar el registro");
        }
        return response;
    }

    public TRatesResponse updateTRatesPrice(Long id, Integer price) {
        Optional<TRates> tRatesOptional = findById(id);
        TRatesResponse response = new TRatesResponse();

        if (!tRatesOptional.isEmpty()) {
            TRates tRates = tRatesOptional.get();
            tRates.setPrice(price);
            response.setTRates(setTrates(tRates));
            response.setResult("00");
        } else {
            response.setResult("01");
            response.setMessageDescription("Error al actualizar el registro");
        }
        return response;
    }

    public TRatesListResponse findByFilter(TRatesFilterRequest request) throws ParseException {
        List<TRates> tRatesList = findByFilterProductBrandDate(request);
        TRatesListResponse response = new TRatesListResponse();
        if (!tRatesList.isEmpty()) {
            response.setTRatesList(tRatesList);
            response.setResult("00");
        } else {
            response.setResult("00");
            response.setMessageDescription("No se han encontrado datos");
        }
        return response;
    }
}
