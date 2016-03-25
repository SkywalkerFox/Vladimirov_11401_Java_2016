package ru.kpfu.itis.pavelvladimirov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Павел on 23.03.2016.
 */
@Controller
@RequestMapping("/process")
public class ProcessController {
    @RequestMapping(method = RequestMethod.GET)
    public String processPage() {
        return "process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getResult(HttpServletResponse response, @RequestParam Map<String, String> params) {
        String text = params.get("comment");
        String option = params.get("oper");
        if (option.contains("characters")) {
            Cookie cookie = new Cookie("result", String.valueOf(text.length()));
            response.addCookie(cookie);
        }
        if (option.contains("words")) {
            String[] words = text.split(" ");
            Cookie cookie = new Cookie("result", String.valueOf(words.length));
            response.addCookie(cookie);
        }
        if (option.contains("proposals")) {
            String[] proposals = text.split("\\.");
            Cookie cookie = new Cookie("result", String.valueOf(proposals.length));
            response.addCookie(cookie);
        }
        if (option.contains("paragraphs")) {
            String[] paragraphs = text.split("\\n");
            Cookie cookie = new Cookie("result", String.valueOf(paragraphs.length));
            response.addCookie(cookie);
        }
        return new ModelAndView("redirect:/result");
    }
}
