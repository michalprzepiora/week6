package pl.com.przepiora.week6.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieMailAspect  {

  @Autowired
  private JavaMailSender mailSender;

  @Before("execution(void pl.com.przepiora.week6.controller.MovieApi.addMovie(*))")
  public void test(){
    System.out.println("start");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("michal.przepiora@gmail.com");
    message.setSubject("Test spring mail");
    message.setText("To jest tresc wiadomosci");
    mailSender.send(message);

    System.out.println("stop");

  }

}
