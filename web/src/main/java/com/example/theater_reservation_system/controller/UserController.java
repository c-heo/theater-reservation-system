package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.theater_reservation_system.service.UserService;
import com.example.theater_reservation_system.entity.User;


@Controller
public class UserController extends BaseController {

  private final UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @RequestMapping("/profile")
  public String getProfile(Model model) {
    Iterable<User> users = service.findAll();
    model.addAttribute("users", users);
    return template("users/show", model, "プロフィール");
  }
}
