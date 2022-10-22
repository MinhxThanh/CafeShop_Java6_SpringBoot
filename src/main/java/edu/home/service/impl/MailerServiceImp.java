package edu.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import edu.home.common.model.MailInfoForgotPassword;
import edu.home.common.model.MailInfoOrder;
import edu.home.common.until.FormMailForgotPassword;
import edu.home.common.until.FormMailOrder;
import edu.home.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class MailerServiceImp implements MailerService {
    private List<MailInfoOrder> list = new ArrayList<>();
    private MailInfoForgotPassword mailInfoForgotPassword = new MailInfoForgotPassword();

    @Autowired
    private JavaMailSender sender;
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private FormMailOrder formMailOrder;
    @Autowired
    private FormMailForgotPassword formMailForgotPassword;

    @Override
    public void send(MailInfoOrder mail) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        // Sử dụng Helper để thiết lập các thông tin cần thiết cho message
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        String html = formMailOrder.content(mail.getOrderID());
//        String html = templateEngine.process("mail", (IContext) order);

        helper.setFrom(mail.getFrom());
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(html, true);
        helper.setReplyTo(mail.getFrom());

        // Gửi message đến SMTP server
        sender.send(message);
        System.out.println("send!!!!!!!");
    }

    @Override
    public void queue(MailInfoOrder mail) {
        list.add(mail);
    }

    @Override
    public void sendMailForgotPasswordDelay(MailInfoForgotPassword mail){
        System.out.println("sendMailForgotPasswordDelay1: " + mail.getFrom() );
        System.out.println("sendMailForgotPasswordDelay2: " + mail.getUsername() );

        mailInfoForgotPassword.setFrom(mail.getFrom());
        mailInfoForgotPassword.setSubject(mail.getSubject());
        mailInfoForgotPassword.setUsername(mail.getUsername());
        mailInfoForgotPassword.setTo(mail.getTo());
    }

    @Override
    public void sendMailForgotPassword(MailInfoForgotPassword mail) throws MessagingException {
        String html = formMailForgotPassword.content(mail.getUsername(), mail.getTo());
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        helper.setFrom(mail.getFrom());
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(html, true);
        helper.setReplyTo(mail.getFrom());

        // Gửi message đến SMTP server
        sender.send(message);
        System.out.println("send!!!!!!!");

    }
    public void sendMailForm(MailInfoForgotPassword mail, String html){

    }

    @Scheduled(fixedDelay = 3000)
    public void run() {
        System.out.println("this 3");

        if (mailInfoForgotPassword != null){
            try {
                System.out.println("this 2");
                System.out.println("this 4: " +mailInfoForgotPassword.getUsername());

                this.sendMailForgotPassword(mailInfoForgotPassword);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("this 1");
        }else {
            System.out.println("mail null!!");
        }
    }
}
