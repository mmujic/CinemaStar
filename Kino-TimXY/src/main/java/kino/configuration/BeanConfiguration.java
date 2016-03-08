package kino.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

@Configuration
public class BeanConfiguration {
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("kino");
    }

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername("kino.timxy108@gmail.com");
        mailSender.setPassword("random");
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "false");
        properties.setProperty("mail.smtp.starttls.enable", "false");
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

    @Bean
    public EntityManager entityManager() {
        return  entityManagerFactory().createEntityManager();
    }

}
