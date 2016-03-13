package kino.model;

import kino.configuration.PersistenceConfiguration;
import kino.model.repositories.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModelFactory {
    private final UserRepository userRepository;

    private ModelFactory() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
        userRepository = applicationContext.getBean(UserRepository.class);
    }
    public UserRepository UserRepository() {
        return userRepository;
    }
    public static ModelFactory getInstance() {
        return new ModelFactory();
    }
}
