package com.example.theater_reservation_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Ticket;
import com.example.theater_reservation_system.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  TicketRepository reservationRepository;

  public Iterable<Ticket> findLoginUserTickets() {
    Iterable<Ticket> tickets = reservationRepository.findByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    return tickets;
  }

  public void deleteTicket(UUID id){
    reservationRepository.deleteById(id);
  }
}
