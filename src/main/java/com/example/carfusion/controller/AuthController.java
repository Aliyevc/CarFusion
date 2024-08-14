package com.example.carfusion.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basicauth")
public class AuthController {

    @ModelAttribute
    @PostMapping("/auth")
    public String message(@ModelAttribute CreateUserRequest createUserRequest, BindingResult bindingResult) {

        userService.saveUser(createUserRequest);
        return "auth";
    }
}
