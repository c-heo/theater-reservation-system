package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.service.ReservationService;
import com.example.theater_reservation_system.entity.Reservation;


@Controller
public class ReservationController extends BaseController {

  private final ReservationService service;

  @Autowired
  public ReservationController(ReservationService service) {
    this.service = service;
  }

  @RequestMapping("/reservations")
  public String getMovies(Model model) {
    Iterable<Reservation> reservations = service.findAll();
    model.addAttribute("reservations", reservations);
    return template("reservations/index", model, "予約一覧");
  }
}
