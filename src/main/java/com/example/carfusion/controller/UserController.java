package com.example.carfusion.controller;

import com.example.carfusion.model.dto.request.CreateUserRequest;
import com.example.carfusion.model.dto.update.UpdateUserRequest;
import com.example.carfusion.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor

public class UserController {

    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUser(updateUserRequest));
    }

}
