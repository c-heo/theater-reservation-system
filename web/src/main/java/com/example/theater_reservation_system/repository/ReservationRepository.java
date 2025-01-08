package com.example.theater_reservation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_reservation_system.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
