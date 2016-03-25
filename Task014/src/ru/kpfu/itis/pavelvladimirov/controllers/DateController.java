package ru.kpfu.itis.pavelvladimirov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Павел on 23.03.2016.
 */
@Controller
@RequestMapping("/getdate")
public class DateController {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage(ModelMap modelMap) {
        modelMap.put("date", new Date().toString().replace(':', '-'));
        return "date";
    }
}
