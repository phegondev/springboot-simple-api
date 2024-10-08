package com.phegondev.UserApi.service;

import com.phegondev.UserApi.model.User;
import com.phegondev.UserApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getIUserById(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }
     public User updateUser(User userToUpdate, Long userId){

        User user = userRepository.findById(userId).orElseThrow();
        user.setName(userToUpdate.getName());
        user.setDob(userToUpdate.getDob());
        return userRepository.save(user);
     }

     public void deleteUser(Long userId){
         if (userRepository.existsById(userId)) {
             userRepository.deleteById(userId);
         }
     }
}
