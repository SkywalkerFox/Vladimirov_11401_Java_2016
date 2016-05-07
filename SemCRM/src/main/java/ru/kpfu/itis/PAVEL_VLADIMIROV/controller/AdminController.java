package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.ActivitiesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.RequestedSuppliesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.SentSuppliesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Павел on 07.05.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ActivitiesService activitiesService;

    @Autowired
    UserService userService;

    @Autowired
    RequestedSuppliesService requestedSuppliesService;

    @Autowired
    SentSuppliesService sentSuppliesService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showAdminHomePage(HttpServletRequest request, ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }
        User currentUser = (User) authentication.getPrincipal();
        map.put("admin", currentUser.getFirstName());

        List<Activities> activities = activitiesService.getLast6();
        Collections.reverse(activities);
        map.put("activities", activities);

        List<User> users = userService.getAll();
        users.remove(currentUser);
        map.put("users", users);

        HashMap<String, Integer> requestedMap = new HashMap<>();
        for (User user : users) {
            requestedMap.put(user.getEmail(), requestedSuppliesService.getAllForUser(user.getId()).size());
        }
        HashMap<String, Integer> sentMap = new HashMap<>();
        for (User user : users) {
            sentMap.put(user.getEmail(), sentSuppliesService.getAllForUser(user.getId()).size());
        }
        map.put("requested", requestedMap);
        map.put("sent", sentMap);

        List<Activities> lastLoggedIn = activitiesService.getLastLoggedIn();
        Collections.reverse(lastLoggedIn);
        map.put("lastLoggedIn", lastLoggedIn);

        HashMap<String, Integer> activeUsers = new HashMap<>();
        for (User user : users) {
            activeUsers.put(user.getEmail(), requestedMap.get(user.getEmail()) + sentMap.get(user.getEmail()));
        }
        int min = activeUsers.get(users.get(0).getEmail());
        String email = "";
        while(activeUsers.size() > 5) {
            for (User user : users) {
                if (activeUsers.get(user.getEmail()) != null && activeUsers.get(user.getEmail()) <= min) {
                    min = activeUsers.get(user.getEmail());
                    email = user.getEmail();
                }
            }
            activeUsers.remove(email, min);
        }
        map.put("activeUsers", activeUsers);


        return "admin_home";
    }

    @RequestMapping(value = "/supply", method = RequestMethod.GET)
    public String showAdminSuppliesPage(HttpServletRequest request, ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }
        User currentUser = (User) authentication.getPrincipal();
        map.put("admin", currentUser.getFirstName());

        List<RequestedSupplies> requestedSupplies = requestedSuppliesService.getAll();
        map.put("requestedSupplies", requestedSupplies);

        List<SentSupplies> sentSupplies = sentSuppliesService.getAll();
        map.put("sentSupplies", sentSupplies);

        List<User> users = userService.getAll();
        map.put("users", users);

        return "admin_supply";
    }



}
