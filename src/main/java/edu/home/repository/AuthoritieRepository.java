package edu.home.repository;

import edu.home.model.Account;
import edu.home.model.Authoritie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthoritieRepository extends JpaRepository<Authoritie, Integer> {
    @Query("select distinct au from Authoritie au where au.account in ?1")
    List<Authoritie> authoritiesOf(List<Account> accounts);
}