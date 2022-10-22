package edu.home.rest.controller;

import edu.home.model.Role;
import edu.home.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class RolesRestController {
    @Autowired
    private RoleService roleService;

    @GetMapping("roles")
    public List<Role> getAll(){
        return roleService.findAll();
    }
}
