package pl.com.przepiora.week6.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class MovieMailAspect {

    private final Logger log = LoggerFactory.getLogger(MovieMailAspect.class);

    private final JavaMailSender mailSender;

    public MovieMailAspect(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Before("execution(void pl.com.przepiora.week6.controller.MovieApi.addMovie(*))")
    public void test() {
        SimpleMailMessage message = new SimpleMailMessage();
        String date = LocalDateTime.now().toString();
        log.info("Mail is sending...");
        message.setTo("michal.przepiora@gmail.com");
        message.setSubject("Information");
        message.setText("New movie was added to repository. \n" + date);
        mailSender.send(message);
        log.info("Mail was send.");
    }

}
