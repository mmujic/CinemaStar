package kino.model;

import kino.configuration.PersistenceConfiguration;
import kino.model.repositories.CommentRepository;
import kino.model.repositories.EventRepository;
import kino.model.repositories.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModelFactory {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;

    private ModelFactory() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
        userRepository = applicationContext.getBean(UserRepository.class);
        eventRepository = applicationContext.getBean(EventRepository.class);
        commentRepository = applicationContext.getBean(CommentRepository.class);
    }

    public static ModelFactory getInstance() {
        return new ModelFactory();
    }

    public UserRepository UserRepository() {
        return userRepository;
    }

    public EventRepository EventRepository() {
        return eventRepository;
    }

    public CommentRepository CommentRepository() {
        return commentRepository;
    }
}
