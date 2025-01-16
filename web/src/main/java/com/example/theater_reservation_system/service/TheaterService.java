package com.example.theater_reservation_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Theater;
import com.example.theater_reservation_system.repository.TheaterRepository;

@Service
public class TheaterService {

  @Autowired
  TheaterRepository theaterRepository;

  public Iterable<Theater> findAll() {
    Iterable<Theater> theaters = theaterRepository.findAll();
    return theaters;
  }

  public Theater findById(UUID id){
    Theater theater = theaterRepository.findById(id);
    return theater;
  }
}
