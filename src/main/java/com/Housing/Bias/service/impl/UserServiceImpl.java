package com.Housing.Bias.service.impl;

import com.Housing.Bias.customexception.UserNotFoundException;
import com.Housing.Bias.dto.UserDTO;
import com.Housing.Bias.entity.User;
import com.Housing.Bias.repository.UserRepository;
import com.Housing.Bias.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

   @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public User createUser(User user) {
        User userToBeSavedToDB = this.userRepository.save(user);
        return userToBeSavedToDB;
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = this.userRepository.findById(userId).get();
        UserDTO userDTO = this.modelMapper().map(user,UserDTO.class);
        return userDTO;
    }

    public List<User> getAllUsers() {return userRepository.findAll();}

    public User updateUser(Long id, User updatedUser) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    updatedUser.setUserId(id);
                    return userRepository.save(updatedUser);
                });
    }
    public boolean deleteUser(Long id) throws UserNotFoundException {

        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
