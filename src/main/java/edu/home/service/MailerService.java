package edu.home.service;

import javax.mail.MessagingException;

import edu.home.common.model.MailInfoForgotPassword;
import edu.home.common.model.MailInfoOrder;


public interface MailerService {
    void send(MailInfoOrder mail) throws MessagingException;
    void queue(MailInfoOrder mail);

    void sendMailForgotPassword(MailInfoForgotPassword mail) throws MessagingException;

    void sendMailForgotPasswordDelay(MailInfoForgotPassword mail);
}
