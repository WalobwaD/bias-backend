package com.Housing.Bias.controller;

import com.Housing.Bias.entity.House;
import com.Housing.Bias.entity.User;
import com.Housing.Bias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public Optional<User> getUser(User user) {
        return userService.getUserById(user.getUserid());
        //return userService.getUserById(user.getUserid()).orElseThrow(NoSuchElementException::new);
        //return Optional.ofNullable(userService.getUserById(user.getUserid()).orElseThrow(NoSuchElementException::new));
    }
    @GetMapping
    public List<User> getUsers() { return userService.getAllUsers(); }
    @PostMapping
    public User postUser(@RequestBody User user) {  return userService.createUser(user);    }

    // CREATE UPDATEUSER METHOD
//    @PutMapping("{id}")
//    public User updateuser(@PathVariable("id") Long id, @RequestBody User incomingUser) {
//        Optional<User> user = userService.getUserById(id);
//        if (user.isPresent()) {
//            user
//        }
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

}
