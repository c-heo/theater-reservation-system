package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController {
  @RequestMapping("/login")
  public String login(Model model) {
    return "login";
  }
}
