package edu.home.service.impl;

import edu.home.model.ImageDescribe;
import edu.home.repository.ImageDescribeRepository;
import edu.home.service.ImageDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageDescribeServiceImpl implements ImageDescribeService {
    @Autowired
    private ImageDescribeRepository dao;

    @Override
    public List<ImageDescribe> findAllImageDescribeByProductID(Integer productId) {
        return dao.findAllByProductId(productId);
    }
}
