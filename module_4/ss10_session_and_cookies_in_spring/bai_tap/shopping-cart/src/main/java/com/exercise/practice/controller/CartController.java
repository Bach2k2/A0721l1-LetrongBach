package com.exercise.practice.controller;

import com.exercise.practice.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @ModelAttribute("/cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView model = new ModelAndView("/cart");
        model.addObject("cart", cart);
        return model;
    }
}
