package kino.controller;

import kino.model.ModelFactory;
import kino.model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

    ModelFactory modelFactory = ModelFactory.getInstance();

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public @ResponseBody UserViewModel getAllUsers() {
        return new UserViewModel(1,"cf","sa","gsa","sgh",true);
    }

    @RequestMapping(value = "/getUser1", method = RequestMethod.GET)
    public @ResponseBody UserViewModel getAllUsers1() {
        UserViewModel userViewModel=new UserViewModel();
        userViewModel.setName("asasd");
        return userViewModel;
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
