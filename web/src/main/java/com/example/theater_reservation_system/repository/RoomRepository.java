package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
  public Room findById(UUID uuid);
}
