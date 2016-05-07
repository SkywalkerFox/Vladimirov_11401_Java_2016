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
 * Created by Павел on 20.04.2016.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @RequestMapping(method = RequestMethod.GET)
    public String showProfile(ModelMap map, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());
            return "profile";
        }

        return "redirect:/home";
    }
}
