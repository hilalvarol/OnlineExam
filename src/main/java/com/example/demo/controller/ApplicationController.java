package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ApplicationController {
    private UserService userService;

    public ApplicationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("user"))
                    username = cookie.getValue();
        model.addAttribute("username", username);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userService.findByEmail(username);
            System.out.println(user + "entered");
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
                for (Cookie cookie : cookies)
                    if (!cookie.getName().equals("user")) {
                        Cookie newCookie = new Cookie("user", username);
                        newCookie.setMaxAge(60 * 60 * 4);
                        response.addCookie(newCookie);
                    }
            if (user.getPassword().equals(password)) {
                request.getSession().invalidate();
                HttpSession newSession = request.getSession();
                newSession.setMaxInactiveInterval(3600);
                String encode = response.encodeURL(request.getContextPath());
                model.addAttribute("user", user);
                newSession.setAttribute("user", user);
                return "redirect:" + encode + user.getRole().toLowerCase();
            }
        } catch (RuntimeException e) {
            return "redirect:/";
        }
        return "redirect:/";
    }



}
