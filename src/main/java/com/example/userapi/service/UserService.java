package com.example.userapi.service;

import com.example.userapi.dto.UserRequest;
import com.example.userapi.dto.UserResponse;
import com.example.userapi.exception.UserNotFoundException;
import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponse> getAllUsers() {
        return repository.findAll().stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getAge()))
                .toList();
    }

    public UserResponse getUserByIdResponse(Long id) {
        User u = getUserById(id);
        return new UserResponse(u.getId(), u.getName(), u.getAge());
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        User saved = repository.save(user);
        return new UserResponse(saved.getId(), saved.getName(), saved.getAge());
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        User user = getUserById(id);
        user.setName(request.getName());
        user.setAge(request.getAge());
        User updated = repository.save(user);
        return new UserResponse(updated.getId(), updated.getName(), updated.getAge());
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }

    private User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }
}