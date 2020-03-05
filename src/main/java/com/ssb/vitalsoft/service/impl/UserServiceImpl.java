package com.ssb.vitalsoft.service.impl;

import com.ssb.vitalsoft.dao.UserRepository;
import com.ssb.vitalsoft.model.User;
import com.ssb.vitalsoft.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public String login(String username, String password) {
        Optional<User> user = userRepository.login(username,password);
        if(user.isPresent()){
            String token = UUID.randomUUID().toString();
            User user1= user.get();
            user1.setToken(token);
            userRepository.save(user1);
            return token;
        }

        return StringUtils.EMPTY;
    }


    @Override
    public Optional<User> findByToken(String token) {
        Optional<User> user= userRepository.findByToken(token);
        if(user.isPresent()){
            User user1 = user.get();

            return Optional.of(user1);
        }
        return  Optional.empty();
    }

    @Override
    public List<User> getUser() {
        return (List)userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
       Optional<User> user= userRepository.findById(id);
        return user;
    }

}

