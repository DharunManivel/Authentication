package com.ssb.vitalsoft.service;

import com.ssb.vitalsoft.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Iterable<User> getUser();
    User saveUser(User user);
    Optional<User> findById(String id);
    Optional<User> findByToken(String token);
     String login(String username, String password);



}
