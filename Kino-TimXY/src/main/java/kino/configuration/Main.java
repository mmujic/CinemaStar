package kino.configuration;

import kino.model.ModelFactory;
import kino.model.entities.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ModelFactory modelFactory = ModelFactory.getInstance();
//        System.out.println(modelFactory.UserRepository().findByName("Kurt Cobain").get(0));

        User user = new User();
        user.setAddress("Zmaja od Bosne bb");
        user.setName("Narcis Behlilovic");
        user.setAdmin(false);
        user.setEmail("cizi@live.com");
        user.setNumber("033-225-883");
        modelFactory.UserRepository().saveAndFlush(user);

        Event event = new Event();

        event.setName("Brucosijada");
        event.setDescription("Loodilo, oduzimanje, mnozenje, dijeljene, rastavljanje na proste faktore.");
        event.setTimeBegin(new Date());
        event.setTimeEnd(new Date());
        modelFactory.EventRepository().saveAndFlush(event);

        Comment comment = new Comment();

        comment.setContent("Bilo je ludo i nezaboravno.");
        comment.setTime(new Date());
        comment.setEvent(event);
        comment.setUser(user);

        System.out.println(user.getId()+"   "+event.getId());

        modelFactory.CommentRepository().saveAndFlush(comment);
        System.out.println("User ID: "+user.getId());

        User fromDB = modelFactory.UserRepository().getOne(user.getId());

        if (fromDB == null)
            throw new RuntimeException("Nije ga fino spremio.");

        if(fromDB.getComments().isEmpty()) {
            System.out.println("No comments for user with given ID.");
            System.exit(-1);
        }
        System.out.println("User comments:");
        for (int i = 0; i < fromDB.getComments().size(); i++) {
            System.out.println(fromDB.getComments().get(i).getContent());
        }

        Movie movie=new Movie();
        movie.setDuration(12);
        movie.setDescription("kjashas");
        movie.setName("kjskd");

        modelFactory.MovieRepository().saveAndFlush(movie);

        System.out.println(movie.getId());

        Movie movie1= modelFactory.MovieRepository().getOne(movie.getId());
        System.out.printf(String.valueOf(movie1.getId()));

        Ticket ticket=new Ticket();
        ticket.setSeatY(1);
        ticket.setSeatX(2);
        ticket.setUser(user);
        ticket.setScreening(null);

        modelFactory.TicketRepository().saveAndFlush(ticket);

        Ticket ticket1=modelFactory.TicketRepository().getOne(ticket.getId());

        System.out.printf("assdsd"+String.valueOf(ticket1.getId()));


    }


}