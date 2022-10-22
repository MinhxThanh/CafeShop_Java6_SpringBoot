package edu.home.service;

import edu.home.model.Authoritie;

import java.util.List;

public interface AuthorityService {
    List<Authoritie> findAuthoritiesOfAdministrators();

    List<Authoritie> finAll();

    Authoritie create(Authoritie authoritie);

    void delete(Integer id);
}
