package kino.controller;

import kino.model.ModelFactory;
import kino.model.entities.Movie;
import kino.model.presentation.MovieViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    private final ModelFactory modelFactory = ModelFactory.getInstance();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getMovies() {
        try {
            List<Movie> movies = modelFactory.MovieRepository().findAll();
            List<MovieViewModel> movieViewModels = new ArrayList<>();
            for (Movie movie : movies) {
                MovieViewModel movieViewModel = new MovieViewModel(movie);
                movieViewModels.add(movieViewModel);
            }
            return new ResponseEntity(movieViewModels, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity(generateError("Movie not found."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getMovie(@PathVariable("id") Integer id) {
        try {
            Movie movie=modelFactory.MovieRepository().findOne(id);
            MovieViewModel movieViewModel=new MovieViewModel(movie);
            return new ResponseEntity(movieViewModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(generateError("Movie ID parameter type is unsupported."), HttpStatus.NOT_ACCEPTABLE);
        } catch (NullPointerException e) {
            return new ResponseEntity(generateError(String.format("Movie not found for ID:%d.", id)), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/add",method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity addUser(@RequestBody Movie movie){
        try {
            Movie savedMovie = modelFactory.MovieRepository().saveAndFlush(movie);
            MovieViewModel movieViewModel=new MovieViewModel(savedMovie);
            return new ResponseEntity(movieViewModel, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(generateError("Movie wasn't successfully added"),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public boolean deleteMovie(@PathVariable("id") Integer id) {
        modelFactory.MovieRepository().delete(id);
        Movie movie=modelFactory.MovieRepository().findOne(id);
        if (movie == null) return true;
        else return false;
    }

    private Map<String, String> generateError(String errorInfo) {
        Map error = new HashMap<String, String>();
        error.put("Error", errorInfo);
        return error;
    }
}
