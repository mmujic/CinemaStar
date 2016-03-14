package kino.model;

import kino.configuration.PersistenceConfiguration;
import kino.model.entities.Ticket;
import kino.model.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModelFactory {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;
    private  final MovieRepository movieRepository;

    private ModelFactory() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfiguration.class);
        userRepository = applicationContext.getBean(UserRepository.class);
        eventRepository = applicationContext.getBean(EventRepository.class);
        commentRepository = applicationContext.getBean(CommentRepository.class);
        ticketRepository=applicationContext.getBean(TicketRepository.class);
        movieRepository=applicationContext.getBean(MovieRepository.class);
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

    public TicketRepository TicketRepository(){
        return  ticketRepository;
    }

    public MovieRepository MovieRepository(){
        return movieRepository;
    }

}
