package com.Housing.Bias.controller;

import com.Housing.Bias.customexception.UserNotFoundException;
import com.Housing.Bias.dto.UserDTO;
import com.Housing.Bias.entity.User;
import com.Housing.Bias.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private final UserServiceImpl userServiceImpl;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long userId) {
        UserDTO userDTO = this.userServiceImpl.getUser(userId);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
    @PostMapping(value = "/create/user")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User userCreated = this.userServiceImpl.createUser(newUser);
        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User incomingUser) throws UserNotFoundException {
        return userServiceImpl.updateUser(id, incomingUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        if (userServiceImpl.deleteUser(id)) {
            return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

}
