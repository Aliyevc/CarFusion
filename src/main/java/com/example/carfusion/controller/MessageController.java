package com.example.carfusion.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class MessageController {

    @ModelAttribute
    @GetMapping("/message")
    public String message(Model model) {
        String msg = "Peti";
        model.addAttribute("msg", msg);
        return "message";
    }
}
