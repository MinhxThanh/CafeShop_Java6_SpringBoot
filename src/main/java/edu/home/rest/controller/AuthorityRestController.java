package edu.home.rest.controller;

import edu.home.model.Authoritie;
import edu.home.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class AuthorityRestController {
    @Autowired
    private AuthorityService authorityService;

    @GetMapping(value = "authorities")
    public List<Authoritie> finAll(@RequestParam("admin")Optional<Boolean> admin){
        if (admin.orElse(false))
            return authorityService.findAuthoritiesOfAdministrators();
        return authorityService.finAll();
    }

    @PostMapping(value = "authorities")
    public Authoritie create(@RequestBody Authoritie authoritie){
        return authorityService.create(authoritie);
    }

    @DeleteMapping(value = "authorities/{id}")
    public void delete(@PathVariable("id") Integer id){
        authorityService.delete(id);
    }

}
