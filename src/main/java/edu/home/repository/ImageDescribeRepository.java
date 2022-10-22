package edu.home.repository;

import edu.home.model.ImageDescribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageDescribeRepository extends JpaRepository<ImageDescribe, Integer> {
    @Query("select i from ImageDescribe i where i.product.id = ?1")
    List<ImageDescribe> findAllByProductId(Integer id);
}