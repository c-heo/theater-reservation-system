package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
  public Movie findById(UUID uuid);

  public Page<Movie> findAll(Pageable pageable);
}
