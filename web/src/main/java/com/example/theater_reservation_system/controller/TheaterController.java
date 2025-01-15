package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.service.TheaterService;
import com.example.theater_reservation_system.entity.Theater;


@Controller
public class TheaterController extends BaseController {

  private final TheaterService service;

  @Autowired
  public TheaterController(TheaterService service) {
    this.service = service;
  }

  @RequestMapping("/theaters")
  public String getMovies(Model model) {
    Iterable<Theater> theaters = service.findAll();
    model.addAttribute("theaters", theaters);
    return template("theaters/index", model, "映画館一覧");
  }
}
