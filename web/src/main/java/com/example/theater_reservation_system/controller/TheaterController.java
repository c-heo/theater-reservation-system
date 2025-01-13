package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.repository.TheaterRepository;
import com.example.theater_reservation_system.entity.Theater;


@Controller
public class TheaterController extends BaseController {

  private final TheaterRepository repository;

  @Autowired
  public TheaterController(TheaterRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/theaters")
  public String getMovies(Model model) {
    Iterable<Theater> theaters = repository.findAll();
    model.addAttribute("theaters", theaters);
    return template("theaters/index", model);
  }
}
