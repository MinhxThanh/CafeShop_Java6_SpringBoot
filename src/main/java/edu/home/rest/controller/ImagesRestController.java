package edu.home.rest.controller;

import edu.home.model.ImageDescribe;
import edu.home.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest")
public class ImagesRestController {

    @Autowired
    private ImagesService imagesService;

    @GetMapping(value = "images")
    public List<ImageDescribe> getAll(){
        return imagesService.findAll();
    }

    @GetMapping(value = "images/{id}")
    public ImageDescribe getByImageDescribeID(@PathVariable("id") Integer id){
        return imagesService.findByImageDescribeID(id);
    }

    @PostMapping(value = "images")
    public ImageDescribe create(@RequestBody ImageDescribe imageDescribe){
        return imagesService.create(imageDescribe);
    }

    @DeleteMapping(value = "images/{id}")
    public void delete(@PathVariable("id") Integer id){
        imagesService.delete(id);
    }
}
