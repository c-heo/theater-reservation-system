package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TopController extends BaseController {
  @RequestMapping("/")
  public String getIndex(Model model) {
    return template("index", model);
  }
}
