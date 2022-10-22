package edu.home.rest.controller;

import edu.home.model.ImageDescribe;
import edu.home.service.ImageDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class ImageDescribeRestController {
    @Autowired
    private ImageDescribeService imageDescribeService;

    @GetMapping(value = "imageDescribe/{id}")
    public List<ImageDescribe> getAllImageDescribeByProductID(@PathVariable("id") Integer productId){
        return imageDescribeService.findAllImageDescribeByProductID(productId);
    }

    @GetMapping(value = "imageDescribe/onlyImage/{id}")
    public List<String> getAllImageDescribeByProductID1(@PathVariable("id") Integer productId){
         List<ImageDescribe> imageDescribes = imageDescribeService.findAllImageDescribeByProductID(productId);
         List<String> image = imageDescribes.stream().map(ImageDescribe::getImage).collect(Collectors.toList());
        return image;
    }

    @GetMapping(value = "imageDescribe/findImageByProductId/{id}")
    public ImageDescribe getImageByProductId(@PathVariable("id") Integer productId){
        List<ImageDescribe> imageDescribes = imageDescribeService.findAllImageDescribeByProductID(productId);
        return imageDescribes.stream().findFirst().get();
    }
}
