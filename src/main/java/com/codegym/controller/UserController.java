package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/validateUser")
    public ModelAndView chekValidation(@Validated @ModelAttribute("user") User user, BindingResult br) {
        if (br.hasFieldErrors()) {
            ModelAndView mav = new ModelAndView("/index");
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("/result");
            return mav;
        }
    }
}
