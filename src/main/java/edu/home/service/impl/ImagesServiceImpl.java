package edu.home.service.impl;

import edu.home.model.ImageDescribe;
import edu.home.repository.ImageDescribeRepository;
import edu.home.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImageDescribeRepository dao;

    @Override
    public List<ImageDescribe> findAll() {
        return dao.findAll();
    }

    @Override
    public ImageDescribe findByImageDescribeID(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public ImageDescribe create(ImageDescribe imageDescribe) {
        return dao.save(imageDescribe);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
