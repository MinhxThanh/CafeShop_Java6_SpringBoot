package edu.home.service;

import edu.home.model.ImageDescribe;

import java.util.List;

public interface ImagesService {
    List<ImageDescribe> findAll();

    ImageDescribe findByImageDescribeID(Integer id);

    ImageDescribe create(ImageDescribe imageDescribe);

    void delete(Integer id);
}
