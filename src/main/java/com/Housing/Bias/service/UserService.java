package com.Housing.Bias.service;

import com.Housing.Bias.customexception.UserNotFoundException;
import com.Housing.Bias.dto.UserDTO;
import com.Housing.Bias.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);

    public UserDTO getUser(Long userId);

    public List<User> getAllUsers();

    public User updateUser(Long id, User updatedUser);

    public boolean deleteUser(Long id) throws UserNotFoundException;

}
