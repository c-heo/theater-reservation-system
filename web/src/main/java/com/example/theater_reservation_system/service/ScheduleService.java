package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Schedule;
import com.example.theater_reservation_system.repository.ScheduleRepository;

@Service
public class ScheduleService {

  @Autowired
  ScheduleRepository scheduleRepository;

  public Iterable<Schedule> findAll() {
    Iterable<Schedule> schedules = scheduleRepository.findAll();
    return schedules;
  }
}
