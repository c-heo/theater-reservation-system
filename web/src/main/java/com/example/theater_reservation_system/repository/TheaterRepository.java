package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Movie;
import com.example.theater_reservation_system.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
  public Movie findById(UUID uuid);
}
