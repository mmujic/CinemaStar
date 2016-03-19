package kino.controller;

import kino.model.ModelFactory;
import kino.model.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    ModelFactory modelFactory = ModelFactory.getInstance();

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserViewModel> getAllUsers() {
        User user=new User();
        user.setName("ilvana");
        UserViewModel userViewModel=new UserViewModel(user);
        ResponseEntity<UserViewModel> foundResponse =
                new ResponseEntity<UserViewModel>(userViewModel, HttpStatus.OK);
        return foundResponse;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user){
        modelFactory.UserRepository().saveAndFlush(user);
        return user;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String testREST() {
        return "Gdje si Mele <3 ";
    }
}
