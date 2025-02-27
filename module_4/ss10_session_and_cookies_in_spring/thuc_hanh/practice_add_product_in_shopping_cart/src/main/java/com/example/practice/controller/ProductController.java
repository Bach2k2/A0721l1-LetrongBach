package com.example.practice.controller;

import com.example.practice.model.Cart;
import com.example.practice.model.Product;
import com.example.practice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView model = new ModelAndView("shop");
        model.addObject("products", productService.findAll());
        return model;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return "/error.404";
        }
        if(action.equals("show"))
        {
            cart.addProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
