package com.Housing.Bias.service;

import com.Housing.Bias.customexception.UserNotFoundException;
import com.Housing.Bias.entity.House;
import com.Housing.Bias.entity.User;
import com.Housing.Bias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {return userRepository.findAll();}
    public Optional<User> getUserById(Long id) {return userRepository.findById(id);}

    public User createUser(User user) {
        // Add business logic if needed before saving
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) throws UserNotFoundException {
        // Add business logic if needed before updating
        if (userRepository.existsById(id)) {
            //why are we setting the id? are we changing the id?
            //I think we should check if the user exists; if he exists, we save the new user object
            updatedUser.setUserId(id);
            return userRepository.save(updatedUser);
        } else {
            // Handle the case where the house with the given id doesn't exist
            throw new UserNotFoundException("User not found");
            //return null;
        }
    }
    public boolean deleteUser(Long id) {
        // Add business logic if needed before deleting
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            // Handle the case where the house with the given id doesn't exist
            return false;
        }
//        try {
//            houseRepository.deleteById(id);
//            return true; // Return true on successful deletion
//        } catch (EmptyResultDataAccessException e) {
//            return false; // Return false if the house with the given ID is not found
//        }
    }

}
