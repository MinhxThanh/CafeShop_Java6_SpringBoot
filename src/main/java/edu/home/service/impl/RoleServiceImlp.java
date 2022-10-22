package edu.home.service.impl;

import edu.home.model.Role;
import edu.home.repository.RoleRepository;
import edu.home.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImlp implements RoleService {
    @Autowired
    private RoleRepository dao;
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }
}
