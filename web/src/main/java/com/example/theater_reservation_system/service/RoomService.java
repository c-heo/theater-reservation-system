package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Room;
import com.example.theater_reservation_system.repository.RoomRepository;

@Service
public class RoomService {

  @Autowired
  RoomRepository roomRepository;

  public Iterable<Room> findAll() {
    Iterable<Room> rooms = roomRepository.findAll();
    return rooms;
  }
}
