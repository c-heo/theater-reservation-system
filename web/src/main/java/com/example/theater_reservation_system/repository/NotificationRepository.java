package com.example.theater_reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
