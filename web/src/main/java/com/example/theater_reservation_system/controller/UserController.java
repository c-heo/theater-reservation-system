package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.theater_reservation_system.repository.UserRepository;
import com.example.theater_reservation_system.entity.User;


@Controller
public class UserController extends BaseController {

  private final UserRepository repository;

  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

	@RequestMapping("/profile")
	public String getProfile(Model model) {
		Iterable<User> users = repository.findAll();
    model.addAttribute("users", users);
    return template("profile", model);
	}
}
