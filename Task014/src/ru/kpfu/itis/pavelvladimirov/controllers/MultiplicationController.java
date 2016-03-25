package ru.kpfu.itis.pavelvladimirov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Павел on 23.03.2016.
 */
@Controller
@RequestMapping("/mult/{arg1:\\d+}/{arg2:\\d+}")
public class MultiplicationController {
    @RequestMapping(method = RequestMethod.GET)
    public String multPage(ModelMap modelMap, @PathVariable String arg1, @PathVariable String arg2) {
        modelMap.put("result", Integer.parseInt(arg1) * Integer.parseInt(arg2));
        return "mult";
    }
}
