package edu.home.service.impl;

import edu.home.model.Rate;
import edu.home.repository.RateRepository;
import edu.home.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository dao;


    @Override
    public void create(Rate rate) {
        dao.save(rate);
    }

    @Override
    public void update(Rate rate) {
        dao.save(rate);
    }

    @Override
    public List<Rate> findAllByProductId(Integer productId) {
        return dao.findAllByProductId(productId);
    }

    @Override
    public void updateByUsernameAndProductId(Integer rateValue, String usernameId, Integer productId) {
        dao.updateByUsernameAndProductId(rateValue, usernameId, productId);
    }

    @Override
    public Rate findByAccountUsernameAndProductId(String usernameId, Integer productId) {
        return dao.findRateByAccountUsernameAndProductId(usernameId, productId);
    }




}
