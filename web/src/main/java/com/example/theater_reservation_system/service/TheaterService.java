package com.example.theater_reservation_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Theater;
import com.example.theater_reservation_system.repository.TheaterRepository;

@Service
public class TheaterService {

  @Autowired
  TheaterRepository theaterRepository;

  public Page<Theater> getTheaters(Pageable pageable) {
    Page<Theater> theaters = theaterRepository.findAll(pageable);
    return theaters;
  }

  public Theater findById(UUID id){
    Theater theater = theaterRepository.findById(id);
    return theater;
  }
}
