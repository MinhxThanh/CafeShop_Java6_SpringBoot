package edu.home.controller;

import edu.home.common.create.InfoAccount;
import edu.home.common.model.AccountForgotPassword;
import edu.home.common.model.MailInfoForgotPassword;
import edu.home.common.model.Register;
import edu.home.model.Account;
import edu.home.service.AccountService;
import edu.home.service.MailerService;
import edu.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.text.DecimalFormat;
import java.util.Random;

@Controller
@RequestMapping(value = "security")
public class SecurityController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private InfoAccount infoAccount;
    @Autowired
    private MailerService mailerService;

    @RequestMapping("login/form")
    public String loginForm(Model model){
        model.addAttribute("pageTitle", "Sign In");
        model.addAttribute("error", "Please login!");
        return "security/login";
    }

    @RequestMapping(value = "login/success")
    public String loginSuccess(Model model){
        model.addAttribute("pageTitle", "Sign In");
        model.addAttribute("message", "Login Successfully!");
        return "security/login";
    }

    @RequestMapping(value = "login/error")
    public String loginFail(Model model){
        model.addAttribute("pageTitle", "Sign In");
        model.addAttribute("error", "Incorrect username or password!");
        return "security/login";
    }

    @RequestMapping(value = "unauthorized")
    public String unauthorized(Model model){
        model.addAttribute("pageTitle", "Sign In");
        model.addAttribute("error", "You account don't unauthorized!");
        return "security/login";
    }

    @RequestMapping(value = "logout/success")
    public String logout(Model model){
        model.addAttribute("pageTitle", "Sign In");
        model.addAttribute("message", "Logout successfully!");
        return "security/login";
    }

    @GetMapping(value = "register")
    public String register(Model model){
        model.addAttribute("register", new Register());
        model.addAttribute("pageTitle", "Register");
        return "security/register";
    }

    @RequestMapping(value = "oauth2Login/success")
    public String oauth2(OAuth2AuthenticationToken oauth2){
        userService.loginFromOAuth2(oauth2);
        return "forward:/security/login/success";
    }

    @PostMapping(value = "register")
    public String registerCreate(Model model, Register register){
        if (accountService.findByUsernameOrEmail(register.getUsername()) != null){
            model.addAttribute("error", "Username or Email has been taken!");
            return "security/register";
        }
        infoAccount.createAccount(register.getUsername(), register.getEmail(), passwordEncoder.encode(register.getPassword()));
        return "redirect:/security/login/form";
    }

    @GetMapping(value = "forgotPassword")
    public String forgotPassword(){
        return "security/forgotPassword";
    }
    @PostMapping(value = "forgotPassword")
    public String forgotPasswordSendEmail(@RequestParam("email") String email, Model model) throws MessagingException {
        Account account = accountService.findByUsernameOrEmail(email);
        if (account == null)
            model.addAttribute("error", "This email don't register");
        else {
            MailInfoForgotPassword mail = new MailInfoForgotPassword();
            mail.setTo(account.getEmail());
            mail.setUsername(account.getUsername());
            mail.setSubject("Reset Your Password");
            mailerService.sendMailForgotPassword(mail);
            model.addAttribute("message", "We had send link for you reset password to this email");
        }
        return "security/forgotPassword";
    }

    @GetMapping(value = "forgotPassword/change/{email}")
    public String changePassword(Model model, @PathVariable("email") String email){
        model.addAttribute("emailAction", email);
        return "security/changePassword";
    }

    @PostMapping(value = "forgotPassword/change/{email}")
    public String changePasswordByEmail(@PathVariable("email") String email,
                                        @RequestParam("password") String password, Model model){
        try {
            accountService.changePasswordByEmail(email, passwordEncoder.encode(password));
            model.addAttribute("message", "Change Password successfully!");
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error", "Please reload this page and try again!");
        }
        return "security/changePassword";
    }
}
