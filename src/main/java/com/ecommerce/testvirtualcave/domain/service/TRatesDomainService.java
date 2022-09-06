package com.ecommerce.testvirtualcave.domain.service;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.domain.repository.TRatesRepository;
import com.ecommerce.testvirtualcave.model.request.TRatesFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TRatesDomainService {

    @Autowired
    private TRatesRepository repository;

    public List<TRates> getTRates() {
        return repository.findAll();
    }

    public TRates setTrates(TRates trates) {
        return repository.save(trates);
    }

    public void deleteTRates(Long id) {
        repository.deleteById(id);
    }

    public Optional<TRates> findById(Long id) {
        return repository.findById(id);
    }

    public List<TRates> findByFilterProductBrandDate(TRatesFilterRequest filter) throws ParseException {
        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(filter.getDate());
        return repository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                filter.getBrandId(), filter.getProductId(), date, date);
    }
}
