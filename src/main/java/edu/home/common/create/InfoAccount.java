package edu.home.common.create;

import edu.home.model.Account;
import edu.home.model.Authoritie;
import edu.home.service.AccountService;
import edu.home.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoAccount {
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private AccountService accountService;
    public Account createAccount(String username, String email, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        account.setAddress("...");
        account.setPhoto("0");
        account.setFullname(username);

        Authoritie authoritie = new Authoritie();
        authoritie.setRole(new InfoRole().createGuest());
        authoritie.setAccount(account);

        accountService.create(account);
        authorityService.create(authoritie);
        return account;
    }
}
