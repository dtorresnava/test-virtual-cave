package com.ecommerce.testvirtualcave.domain.service;

import com.ecommerce.testvirtualcave.domain.model.TRates;
import com.ecommerce.testvirtualcave.domain.repository.TRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
