package kino.model.presentation;

import kino.model.entities.Movie;

public class MovieViewModel {
    private Integer id;

    private String name;

    private String description;

    private Integer duration;

    public MovieViewModel(Movie movie) {
        id=movie.getId();
        name=movie.getName();
        description=movie.getDescription();
        duration=movie.getDuration();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

