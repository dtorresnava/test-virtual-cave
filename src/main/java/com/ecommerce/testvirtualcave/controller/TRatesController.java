package com.ecommerce.testvirtualcave.controller;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.model.Result;
import com.ecommerce.testvirtualcave.model.request.TRatesFilterRequest;
import com.ecommerce.testvirtualcave.model.request.TRatesPartialRequest;
import com.ecommerce.testvirtualcave.model.request.TRatesRequest;
import com.ecommerce.testvirtualcave.model.response.TRatesListResponse;
import com.ecommerce.testvirtualcave.model.response.TRatesResponse;
import com.ecommerce.testvirtualcave.service.TRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/t_rates")
public class TRatesController {

    @Autowired
    private TRatesService service;

    @GetMapping("/all")
    private ResponseEntity<List<TRates>> getAllTRates() {
        List<TRates> response = service.getTRates();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/find")
    private ResponseEntity<TRatesListResponse> find(@RequestBody TRatesFilterRequest request) throws ParseException {
        TRatesListResponse response = service.findByFilter(request);
        if (response.getResult().equals("00")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    private ResponseEntity<TRates> insertTRates(@RequestBody TRatesRequest request) throws ParseException {
        TRates response = service.insertTrates(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    private ResponseEntity<Result> deleteTRates(@PathVariable Long id) {
        Result response = service.delete(id);
        if (response.getResult().equals("00")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<TRatesResponse> updateTRates(@PathVariable Long id, @RequestBody TRatesRequest request) {
        TRatesResponse response = service.updateTRates(id, request);
        if (response.getResult().equals("00")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    private ResponseEntity<TRatesResponse> updateTRatesPrice(@PathVariable Long id, @RequestBody TRatesRequest request) {
        TRatesResponse response = service.updateTRatesPrice(id, request.getPrice());
        if (response.getResult().equals("00")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
