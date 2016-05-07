package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.form.RegistrationForm;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.ActivitiesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Павел on 26.04.2016.
 */
@Controller
//@ComponentScan("ru.kpfu.itis.PAVEL_VLADIMIROV.service")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    ActivitiesService activitiesService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(HttpServletRequest request, Model model) {
        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }
        model.addAttribute("userform", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
                               @RequestParam("email") String email, @RequestParam("password") String password,
                               @RequestParam("sex") String sex, @RequestParam("country") String country,
                               HttpServletRequest request) throws ParseException {
        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }
//        if (result.hasErrors()) {
//            return "redirect:/registration";
//        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole("ROLE_ADMIN");
        user.setCountry(country);
        user.setSex(sex);
        userService.addUser(user);

        Activities activity = new Activities();
        activity.setUserId(userService.getByEmail(user.getEmail()).getId());
        activity.setType("registration");
        activity.setDescription("Новый пользователь " + user.getFirstName() + " " + user.getLastName() + " зарегистрировался");
        activity.setDate(new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date()));
        activitiesService.add(activity);

        return "redirect:/home";
    }

//    @RequestMapping("/default")
//    public String signIn(HttpServletRequest request) {
//        if (request.isUserInRole("ROLE_CONTENT_ADMIN")) {
//            return "redirect:/admin/home";
//        } else {
//            if (request.isUserInRole("ROLE_USER")) {
//                return "redirect:/home";
//            } else {
//                return "redirect:/home";
//            }
//        }
//    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String showSignInPage(HttpServletRequest request, @RequestParam(value = "error", required = false) Boolean error, Model model) {
        System.out.println("user");
        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/home";
        }
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "sign_in";
    }

}
