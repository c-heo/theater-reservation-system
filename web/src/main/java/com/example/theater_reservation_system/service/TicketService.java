package com.example.theater_reservation_system.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Schedule;
import com.example.theater_reservation_system.entity.Ticket;
import com.example.theater_reservation_system.entity.User;
import com.example.theater_reservation_system.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  TicketRepository ticketRepository;

  @Autowired
  ScheduleService scheduleService;

  @Autowired
  UserService userService;

  public Page<Ticket> findLoginUserTickets(Pageable pageable) {
    Page<Ticket> tickets = ticketRepository.findByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName(), pageable);
    return tickets;
  }

  public void createTicket(UUID scheduleId, int seatColumn, String seatRow){
    User user = userService.findLoginUser();
    Schedule schedule = scheduleService.findById(scheduleId);
    Ticket ticket = new Ticket();
    ticket.setSchedule(schedule);
    ticket.setUser(user);
    ticket.setSeatColumn(seatColumn);
    ticket.setSeatRow(seatRow);
    ticket.setCreatedAt(LocalDateTime.now());
    ticketRepository.save(ticket);
  }

  public void deleteTicket(UUID id){
    ticketRepository.deleteById(id);
  }
}
