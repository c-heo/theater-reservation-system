package com.example.theater_reservation_system.controller;

import com.example.theater_reservation_system.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.theater_reservation_system.repository.UserRepository;
import com.example.theater_reservation_system.entity.User;


@Controller
public class TopController extends BaseController {

  private final UserRepository repository;

  @Autowired
  public TopController(UserRepository repository) {
    this.repository = repository;
  }

	@RequestMapping("/")
	public String getIndex(Model model) {
		Iterable<User> users = repository.findAll();
    Boolean isLogin = false;
    if(isLogin) {
      model.addAttribute("users", users);
      return template("user", model);
    } else {
      model.addAttribute("users", users);
      return templateWithoutLogin("user", model);
    }
	}

	@RequestMapping("/login")
	public String login(Model model) {
    return templateWithoutLogin("login", model);
	}
	
}
