package com.epam.springmvcdemo.controller;

import com.epam.springmvcdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private  Map<Integer,User> users = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public String showUserPage(Model model){
     model.addAttribute("user",new User());
     model.addAttribute("users",users);
        return "user-page";
    }

    @PostMapping
    public String save(@ModelAttribute User user,Model model){
         user.setId(users.size()+1);
         users.put(user.getId(), user);

        model.addAttribute("users",users);
        model.addAttribute("user",new User());

        return "user-page";

    }



}
