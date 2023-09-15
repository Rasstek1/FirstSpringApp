package com.martin.firstspringapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
    @GetMapping("/jsp/home.jsp")
    public ModelAndView sayHello() {
        ModelAndView mv=new ModelAndView("/jsp/home.jsp");
        return mv;
    }
}
