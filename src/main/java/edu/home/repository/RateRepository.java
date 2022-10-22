package edu.home.repository;

import edu.home.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    @Query("select r from Rate r where r.account.username = ?1 and r.product.id = ?2")
    Rate findRateByAccountUsernameAndProductId(String username, Integer productID);
    @Transactional
    @Modifying
    @Query("update Rate r set r.rate = ?1 where r.account.username = ?2 and r.product.id = ?3")
    void updateByUsernameAndProductId(Integer value, String username, Integer productId);

    List<Rate> findAllByProductId(Integer productId);
}