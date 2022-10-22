package edu.home.repository;

import edu.home.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select distinct au.account from Authoritie au where au.role.id in ('ADMIN', 'MANAGE', 'GUEST')")
    List<Account> getAdministrators();

    Account findByUsername(String username);

    @Query("select a from Account a where a.username = ?1 or a.email = ?1")
    Account findByUsernameOrEmail(String key);

    @Transactional
    @Modifying
    @Query("update Account a set a.password =?1 where a.email = ?2")
    void updatePasswordByEmail(String password, String email);
}