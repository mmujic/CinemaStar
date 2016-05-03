package kino.controller;

import kino.utils.SerializableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;
import java.util.Properties;


@Controller
@RequestMapping("/messageBundle")
public class SerializableMessageBundleController {

    SerializableResourceBundleMessageSource messageBundle;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Properties list(@RequestParam String lang) {
        return messageBundle.getAllProperties(new Locale(lang));
    }
}
