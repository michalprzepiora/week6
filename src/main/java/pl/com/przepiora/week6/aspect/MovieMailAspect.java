package pl.com.przepiora.week6.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.com.przepiora.week6.service.MailService;

import java.time.LocalDateTime;

@Aspect
@Component
public class MovieMailAspect {
    private final MailService mailService;
    private final static String MAIL = "michal.przepiora@gmail.com";
    private final static String SUBJECT = "Information RestApi Movie";
    private final static String MESSAGE = "New movie was added to repository";

    public MovieMailAspect(MailService mailService) {
        this.mailService = mailService;
    }

    @Before("execution(void pl.com.przepiora.week6.controller.MovieApi.addMovie(*))")
    public void test() {
        mailService.send(MAIL, SUBJECT, MESSAGE + "\n" + LocalDateTime.now());
    }
}
