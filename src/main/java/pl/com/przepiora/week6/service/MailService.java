package pl.com.przepiora.week6.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String to, String subject, String message) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        log.info("Mail is sending...");
        simpleMessage.setTo(to);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(message);
        mailSender.send(simpleMessage);
        log.info("Mail was send.");
    }
}
