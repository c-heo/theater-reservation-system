package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.repository.NotificationRepository;
import com.example.theater_reservation_system.entity.Notification;


@Controller
public class NotificationController extends BaseController {

  private final NotificationRepository repository;

  @Autowired
  public NotificationController(NotificationRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/notifications")
  public String getMovies(Model model) {
    Iterable<Notification> theaters = repository.findAll();
    model.addAttribute("notifications", theaters);
    return template("notifications/index", model);
  }
}
