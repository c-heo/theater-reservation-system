package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.theater_reservation_system.service.ScheduleService;
import com.example.theater_reservation_system.entity.Schedule;


@Controller
public class ScheduleController extends BaseController {

  private final ScheduleService service;

  @Autowired
  public ScheduleController(ScheduleService service) {
    this.service = service;
  }

  @RequestMapping("/schedules/search")
  public String searchSchedules(@RequestParam(name="movieId", required=false) UUID movieId, @RequestParam(name="theaterId", required=false) UUID theaterId, Model model, Pageable pageable) {
    Page<Schedule> schedules= service.searchSchedules(movieId, theaterId, pageable);
    model.addAttribute("page", schedules);
    model.addAttribute("schedules", schedules.getContent());
    return template("schedules/search", model, "スケジュール一覧");
  }
}
