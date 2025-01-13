package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.repository.ReservationRepository;
import com.example.theater_reservation_system.entity.Reservation;


@Controller
public class ReservationController extends BaseController {

  private final ReservationRepository repository;

  @Autowired
  public ReservationController(ReservationRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/reservations")
  public String getMovies(Model model) {
    Iterable<Reservation> reservations = repository.findAll();
    model.addAttribute("reservations", reservations);
    return template("reservations/index", model);
  }
}
