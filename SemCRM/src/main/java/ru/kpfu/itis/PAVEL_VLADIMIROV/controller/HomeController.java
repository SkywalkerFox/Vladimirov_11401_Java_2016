package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Павел on 18.04.2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(ModelMap map, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());
            if (request.isUserInRole("ROLE_ADMIN")) {
                return "redirect:/admin/home";
            }
        }

        return "home";
    }
}
