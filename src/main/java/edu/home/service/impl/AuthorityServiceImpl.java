package edu.home.service.impl;

import edu.home.model.Account;
import edu.home.model.Authoritie;
import edu.home.repository.AccountRepository;
import edu.home.repository.AuthoritieRepository;
import edu.home.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthoritieRepository authoritieRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Authoritie> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountRepository.getAdministrators();
        return authoritieRepository.authoritiesOf(accounts);
    }

    @Override
    public List<Authoritie> finAll() {
        return authoritieRepository.findAll();
    }

    @Override
    public Authoritie create(Authoritie authoritie) {
        return authoritieRepository.save(authoritie);
    }

    @Override
    public void delete(Integer id) {
        authoritieRepository.deleteById(id);
    }
}
