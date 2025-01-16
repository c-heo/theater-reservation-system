package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String getTheaters(Model model) {
    Iterable<Theater> theaters = service.findAll();
    model.addAttribute("theaters", theaters);
    return template("theaters/index", model, "映画館一覧");
  }

  @RequestMapping("/theater/{id:.+}")
  public String getTheater(Model model, @PathVariable("id") UUID theaterId) {
    Theater theater = service.findById(theaterId);
    model.addAttribute("theater", theater);
    return template("theaters/show", model, "");
  }
}
