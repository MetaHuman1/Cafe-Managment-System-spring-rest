package com.inn.cafe.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailUtils {
    @Autowired
    private JavaMailSender emailSender;

    public EmailUtils() {}


    public void sendSimpleMessage(String to, String subject, String text, List<String> list) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("testingusername@mail.ru");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            if (list!=null && list.size()>0)
                message.setCc(getCcArray(list));
            emailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private String[] getCcArray(List<String> ccList) {
        String[] cc= new String[ccList.size()];
        for (int i = 0;i<ccList.size();i++) {
            cc[i] = ccList.get(i);
        }
        return cc;
    }

    public void forgotMail(String to, String subject, String password) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("testingusername@mail.ru");
        helper.setTo(to);
        helper.setSubject(subject);
        String htmlMsg = "<p><b>Your Login details for Cafe Management System</b><br><b>Email: </b> \" + to + \" <br><b>Password: </b> \" + password + \"<br><a href=\\\"http://localhost:4200/\\\">Click here to login</a></p>";
        message.setContent(htmlMsg, "text/html");
        emailSender.send(message);
    }
}














