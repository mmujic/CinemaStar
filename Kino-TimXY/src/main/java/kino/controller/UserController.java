package kino.controller;

import kino.model.ModelFactory;
import kino.model.entities.Movie;
import kino.model.entities.User;
import kino.model.presentation.UserViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final ModelFactory modelFactory = ModelFactory.getInstance();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsers() {
        try {
            List<User> users = modelFactory.UserRepository().findAll();
            List<UserViewModel> userViewModels = new ArrayList<>();
            for(User user : users) {
                userViewModels.add(new UserViewModel(user));
            }
            return new ResponseEntity(userViewModels, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity(generateError("User not found."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        try {
            User user = modelFactory.UserRepository().findOne(id);
            UserViewModel userViewModel = new UserViewModel(user);
            return new ResponseEntity(userViewModel, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(generateError("User ID parameter type is unsupported."), HttpStatus.NOT_ACCEPTABLE);
        } catch (NullPointerException e) {
            return new ResponseEntity(generateError(String.format("User not found for ID:%d.", id)), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateError("Something unusual happened. Please try again later."), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/add",method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user){
        try {
            User savedUser = modelFactory.UserRepository().saveAndFlush(user);
            UserViewModel userViewModel = new UserViewModel(savedUser);
            return new ResponseEntity(userViewModel, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(generateError("User wasn't successfully added"),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        modelFactory.UserRepository().delete(id);
        User user=modelFactory.UserRepository().findOne(id);
        if (user == null) return true;
        else return false;
    }

    private Map<String, String> generateError(String errorInfo) {
        Map error = new HashMap<String, String>();
        error.put("Error", errorInfo);
        return error;
    }
}
