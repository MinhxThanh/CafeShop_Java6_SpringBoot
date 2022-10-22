package edu.home.rest.controller;

import edu.home.model.Account;
import edu.home.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "accounts")
    public List<Account> getAll(@RequestParam("admin")Optional<Boolean> admin){
        if (admin.orElse(false))
            return accountService.getAdministrators();
        return accountService.findAll();
    }
}
