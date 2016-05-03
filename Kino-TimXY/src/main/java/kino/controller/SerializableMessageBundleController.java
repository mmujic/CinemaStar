package kino.controller;

import kino.utils.SerializableResourceBundleMessageSource;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> af47c496854401ba08e0003710a238f13f64872c

import java.util.Locale;
import java.util.Properties;


<<<<<<< HEAD
@RestController
@RequestMapping("/messageBundle")
public class SerializableMessageBundleController {

    @Autowired
=======
@Controller
@RequestMapping("/messageBundle")
public class SerializableMessageBundleController {

>>>>>>> af47c496854401ba08e0003710a238f13f64872c
    SerializableResourceBundleMessageSource messageBundle;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Properties list(@RequestParam String lang) {
        return messageBundle.getAllProperties(new Locale(lang));
    }
}
