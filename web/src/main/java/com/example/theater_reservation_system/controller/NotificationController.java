package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.service.NotificationService;
import com.example.theater_reservation_system.entity.Notification;


@Controller
public class NotificationController extends BaseController {

  private final NotificationService service;

  @Autowired
  public NotificationController(NotificationService service) {
    this.service = service;
  }

  @RequestMapping("/notifications")
  public String getMovies(Model model) {
    Iterable<Notification> notifications = service.findAll();
    model.addAttribute("notifications", notifications);
    return template("notifications/index", model, "通知一覧");
  }
}
