package ru.kpfu.itis.pavelvladimirov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Павел on 23.03.2016.
 */
@Controller
@RequestMapping("/result")
public class ResultController {
    @RequestMapping(method = RequestMethod.GET)
    public String showResult(ModelMap modelMap, @CookieValue("result") String result) {
        modelMap.put("result", result);
        return "result";
    }
}
