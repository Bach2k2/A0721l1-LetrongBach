package com.example.demo.controller;

import com.example.demo.model.User;
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
    public ModelAndView showForm()
    {
        ModelAndView modelAndView=new ModelAndView("/index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
     @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult)
     {
         ModelAndView model;
         if(bindingResult.hasErrors())
         {
             model=new ModelAndView("/index");
             return model;
         }
         model=new ModelAndView("/result");
         model.addObject("user",user);
         return model;
     }
}
