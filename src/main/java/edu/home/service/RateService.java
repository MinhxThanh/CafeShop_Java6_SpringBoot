package edu.home.service;

import edu.home.model.Rate;

import java.util.List;

public interface RateService {
    void create(Rate rate);

    Rate findByAccountUsernameAndProductId(String usernameId, Integer productId);

    void update(Rate rate);

    List<Rate> findAllByProductId(Integer productId);

    void updateByUsernameAndProductId(Integer rateValue, String usernameId, Integer productId);
}
