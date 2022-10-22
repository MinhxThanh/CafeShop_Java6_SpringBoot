package edu.home.service;

import edu.home.model.ImageDescribe;

import java.util.List;

public interface ImageDescribeService {
    List<ImageDescribe> findAllImageDescribeByProductID(Integer productId);
}
