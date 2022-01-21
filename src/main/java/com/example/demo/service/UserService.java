package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> findAll(){
       return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findById(String id){
        return userRepository.findById1(id).orElseThrow();
    }
    public User findByEmail(String email){
        return userRepository.findById(email).orElseThrow();
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
}
