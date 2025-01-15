package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Reservation;
import com.example.theater_reservation_system.repository.ReservationRepository;

@Service
public class ReservationService {

  @Autowired
  ReservationRepository reservationRepository;

  public Iterable<Reservation> findAll() {
    Iterable<Reservation> reservations = reservationRepository.findAll();
    return reservations;
  }
}
