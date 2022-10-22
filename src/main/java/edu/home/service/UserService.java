package edu.home.service;

import edu.home.common.create.InfoAccount;
import edu.home.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private InfoAccount infoAccount;

    @Override
    public UserDetails loadUserByUsername(String username){
        try {
            Account account = accountService.findByUsernameOrEmail(username);
            System.out.println("Username: " + account.getUsername());
            System.out.println("Password: " + account.getPassword());

            //Create userDetail from account
            String password = account.getPassword();
            String[] roles = account.getAuthorities().stream()
                    .map(a -> a.getRole().getId())
                    .collect(Collectors.toList()).toArray(new String[0]);
            return User.withUsername(username)
                    .password(password)
                    .roles(roles).build();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception Username 3: " +username);
            throw new UsernameNotFoundException(username + "not found!");
        }
    }

    public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
        String username = oauth2.getPrincipal().getAttribute("name");
        String email = oauth2.getPrincipal().getAttribute("email");
        String password = oauth2.getPrincipal().getName();

        if (accountService.findByUsernameOrEmail(email) != null){
            System.out.println("This email already exists in data");
        }else {
            infoAccount.createAccount(username, email, passwordEncoder.encode(password));
        }

        UserDetails userDetails = User.withUsername(email)
                .password(passwordEncoder.encode(password)).roles("GUEST").build();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
