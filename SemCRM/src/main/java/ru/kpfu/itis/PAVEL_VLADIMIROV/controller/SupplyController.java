package ru.kpfu.itis.PAVEL_VLADIMIROV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.RequestedSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.ActivitiesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.RequestedSuppliesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.SentSuppliesService;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Павел on 20.04.2016.
 */
@Controller
@RequestMapping("/supply")
public class SupplyController {

    @Autowired
    RequestedSuppliesService requestedSuppliesService;

    @Autowired
    UserService userService;

    @Autowired
    SentSuppliesService sentSuppliesService;

    @Autowired
    ActivitiesService activitiesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showSupplies(ModelMap map, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("user", currentUser);

            List<RequestedSupplies> requestedSupplies = requestedSuppliesService.getAllForUser(currentUser.getId());
            map.put("requestedSupplies", requestedSupplies);

            List<RequestedSupplies> requestedSuppliesAll = requestedSuppliesService.getAll();
            map.put("requestedSuppliesAll", requestedSuppliesAll);

            List<User> users = userService.getAll();
            map.put("users", users);

            List<SentSupplies> sentSupplies = sentSuppliesService.getAllForUser(currentUser.getId());
            map.put("sentSupplies", sentSupplies);

            return "supply";
        }
        return "redirect:/home";
    }


    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String showRequestForSupplyForm(HttpServletRequest request, ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());

            return "request_supply";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String makeRequestForSupply(HttpServletRequest request, ModelMap map, @RequestParam String name,
                                       @RequestParam String description, @RequestParam Integer size) throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());
            RequestedSupplies supply = new RequestedSupplies();
            supply.setName(name);
            supply.setDescription(description);
            supply.setSize(size);
            supply.setStatus("processing");
            supply.setRequesterId(currentUser.getId());
            supply.setDate(new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date()));
            requestedSuppliesService.addSupply(supply);

            Activities activity = new Activities();
            activity.setUserId(currentUser.getId());
            activity.setType("request");
            activity.setDescription("Пользователь " + currentUser.getFirstName() + " " + currentUser.getLastName() + " сделал запрос на поставку");
            activity.setDate(supply.getDate());
            activitiesService.add(activity);

            return "redirect:/supply";
        }
        return "redirect:/request_supply";
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET, params = {"sname", "size", "reciever", "date"})
    public String showSendSupplyFormWithParams(HttpServletRequest request, ModelMap map, @RequestParam String sname, @RequestParam String size,
                                     @RequestParam String reciever, @RequestParam String date) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());

            map.put("sname", sname);
            map.put("size", size);
            map.put("reciever", userService.getById(Integer.valueOf(reciever)).getFirstName() + " "
                    + userService.getById(Integer.valueOf(reciever)).getLastName());
            map.put("date", date);

            return "send_supply";

        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String showSendSupplyForm(HttpServletRequest request, ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            map.put("name", currentUser.getFirstName());

            List<RequestedSupplies> requestedSuppliesAll = requestedSuppliesService.getAll();
            map.put("requestedSuppliesAll", requestedSuppliesAll);

            Set<User> usersWithRequests = new HashSet<>();
            for (RequestedSupplies aRequestedSuppliesAll : requestedSuppliesAll) {
                if (aRequestedSuppliesAll.getStatus().equals("processing")) {
                    usersWithRequests.add(userService.getById(aRequestedSuppliesAll.getRequesterId()));
                }
            }
            usersWithRequests.remove(currentUser);
            map.put("users", usersWithRequests);

            return "send_supply";
        }
        return "redirect:/home";
    }

//    @RequestMapping(value = "/send", method = RequestMethod.POST, params = {"sname", "size", "reciever", "date"})
//    public String sendSupplyWithAutocomplete(HttpServletRequest request, ModelMap map, @RequestParam String sname, @RequestParam Integer size,
//                             @RequestParam Integer reciever, @RequestParam String date) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
//            User currentUser = (User) authentication.getPrincipal();
//            map.put("name", currentUser.getFirstName());
//
//            RequestedSupplies requestedSupply = requestedSuppliesService.getByRequesterIdAndDate(reciever, date);
//            SentSupplies supply = new SentSupplies();
//
//            supply.setName(sname);
//            supply.setReqSupId(requestedSupply.getId());
//            supply.setSize(size);
//            supply.setMass(Double.valueOf(request.getParameter("mass")));
//            supply.setRecieverId(reciever);
//            supply.setDate(new SimpleDateFormat("ddMMyyHHmmss").format(new Date()));
//            supply.setSenderId(currentUser.getId());
//            sentSuppliesService.addSupply(supply);
//            requestedSuppliesService.changeRequestStatus(requestedSupply.getId(), "success");
//
//
//            return "redirect:/supply";
//        }
//        return "redirect:/home";
//    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendSupplyDefault(HttpServletRequest request, ModelMap map) throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN")) {
            User currentUser = (User) authentication.getPrincipal();
            SentSupplies supply = new SentSupplies();

            String namePlusEmail = request.getParameter("reciever");
            String email = namePlusEmail.substring(namePlusEmail.indexOf("(") + 1, namePlusEmail.indexOf(")"));

            String name = request.getParameter("sname");
            Integer size = Integer.valueOf(request.getParameter("size"));
            Double mass = Double.valueOf(request.getParameter("mass"));
            Integer senderId = currentUser.getId();
            Integer recieverId = userService.getByEmail(email).getId();
            Integer reqSupId = requestedSuppliesService.getBySendingForm(name, recieverId, size).getId();

            supply.setName(name);
            supply.setReqSupId(reqSupId);
            supply.setSize(size);
            supply.setMass(mass);
            supply.setSenderId(senderId);
            supply.setRecieverId(recieverId);
            supply.setDate(new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date()));
            sentSuppliesService.addSupply(supply);
            requestedSuppliesService.changeRequestStatus(reqSupId, "success");

            Activities activity = new Activities();
            activity.setUserId(senderId);
            activity.setType("sending");
            activity.setDescription("Пользователь " + currentUser.getFirstName() + " " + currentUser.getLastName() +
                    " отправил поставку для пользователя " + userService.getById(recieverId).getFirstName() + " " +
                    userService.getById(recieverId).getLastName());
            activity.setDate(supply.getDate());
            activitiesService.add(activity);

            map.put("name", currentUser.getFirstName());

            return "redirect:/supply";
        }
        return "redirect:/home";
    }
}
