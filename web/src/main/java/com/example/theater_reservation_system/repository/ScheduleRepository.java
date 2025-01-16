package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
  public Schedule findById(UUID uuid);
}
