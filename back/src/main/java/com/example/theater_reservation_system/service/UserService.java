package com.example.theater_reservation_system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.User;
import com.example.theater_reservation_system.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Iterable<User> findAll() {
    Iterable<User> users = userRepository.findAll();
    return users;
  }

  public User findLoginUser(){
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    Optional<User> user = userRepository.findByEmail(email);
    return user.get();
  }

  public void updateProfile(String username, String email, int points){
    User user = findLoginUser();
    if(username != "") user.setName(username);
    if(email != "") user.setEmail(email);
    if(points != 0) user.setPoints(points);
    userRepository.save(user);
  }
}
