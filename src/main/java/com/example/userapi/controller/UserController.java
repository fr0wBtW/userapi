package com.example.userapi.controller;

import com.example.userapi.dto.UserRequest;
import com.example.userapi.dto.UserResponse;
import com.example.userapi.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return service.getUserByIdResponse(id);
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return service.createUser(request);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return service.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}