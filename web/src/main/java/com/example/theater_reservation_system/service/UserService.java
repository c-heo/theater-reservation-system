package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
