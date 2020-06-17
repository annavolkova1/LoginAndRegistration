package com.anna.controller;

import com.anna.entity.User;
import com.anna.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RestController
public class Controller {
    UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping("/")
    String main() {
        return "Hello from Controller";
    }

    @RequestMapping("/loginForm")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm.html");
        return modelAndView;
    }

    @RequestMapping("/registrationForm")
    ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm.html");
        return modelAndView;
    }

    @PostMapping("/login")
    String login(@RequestParam String login, @RequestParam String password) throws SQLException {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return userService.login(user);
    }

    @PostMapping("/registration")
    String registration(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String login,
            @RequestParam String password
    ) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        return userService.registration(user);
    }
}
