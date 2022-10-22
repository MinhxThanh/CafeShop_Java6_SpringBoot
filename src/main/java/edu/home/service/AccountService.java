package edu.home.service;

import edu.home.model.Account;

import java.util.List;

public interface AccountService {
     Account findById(String id);

    List<Account> getAdministrators();

    List<Account> findAll();

    void create(Account account);

    Account findByUsername(String s);

    Account findByUsernameOrEmail(String username);

    void changePasswordByEmail(String email, String password);
}
