package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Notification;
import com.example.theater_reservation_system.repository.NotificationRepository;

@Service
public class NotificationService {

  @Autowired
  NotificationRepository notificationRepository;

  public Iterable<Notification> findAll() {
    Iterable<Notification> notifications = notificationRepository.findAll();
    return notifications;
  }
}
