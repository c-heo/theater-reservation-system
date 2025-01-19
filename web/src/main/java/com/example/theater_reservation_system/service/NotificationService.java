package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Notification;
import com.example.theater_reservation_system.repository.NotificationRepository;

@Service
public class NotificationService {

  @Autowired
  NotificationRepository notificationRepository;

  public Page<Notification> getNotifications(Pageable pageable) {
    Page<Notification> notifications = notificationRepository.findAll(pageable);
    return notifications;
  }
}
