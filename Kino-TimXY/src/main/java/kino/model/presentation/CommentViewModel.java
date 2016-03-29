package kino.model.presentation;

import kino.model.entities.Comment;
import kino.model.entities.Event;
import kino.model.entities.User;

import java.util.Date;

public class CommentViewModel {

    private Integer id;
    private Date time;
    private String content;
    private User user;
    private Event event;

    public CommentViewModel() {
    }

    public CommentViewModel(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.time = comment.getTime();
        this.user = comment.getUser();
        this.event = comment.getEvent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
