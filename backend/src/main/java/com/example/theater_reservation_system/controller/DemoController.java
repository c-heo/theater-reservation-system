package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.theater_reservation_system.repository.UserRepository;
import com.example.theater_reservation_system.entity.User;

@RestController
public class DemoController {

  private final UserRepository repository;

  @Autowired
  public DemoController(UserRepository repository) {
    this.repository = repository;
  }

	@RequestMapping("/")
	public String getIndex() {
		Iterable<User> users = repository.findAll();
    return String.valueOf(users);
	}
	
}
