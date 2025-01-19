package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer> {
  public News findById(UUID uuid);

  public Page<News> findAll(Pageable pageable);
}
