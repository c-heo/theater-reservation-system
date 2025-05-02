package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public String getNotifications(Model model, Pageable pageable) {
    Page<Notification> notifications = service.getNotifications(pageable);
    model.addAttribute("page", notifications);
    model.addAttribute("notifications", notifications.getContent());
    return template("notifications/index", model, "通知一覧");
  }
}
