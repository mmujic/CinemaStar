package kino.configuration;

import kino.model.ModelFactory;
import kino.model.entities.Comment;
import kino.model.entities.Event;
import kino.model.entities.User;

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
    }

}