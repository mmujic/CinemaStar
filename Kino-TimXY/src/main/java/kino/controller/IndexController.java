package kino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String testREST() {
        return "Gdje si Mele <3 ";
    }
}
