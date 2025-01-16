package com.example.theater_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.entity.News;
import com.example.theater_reservation_system.service.NewsService;


@Controller
public class TopController extends BaseController {

  private final NewsService service;

  @Autowired
  public TopController(NewsService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public String getIndex(Model model) {
    Iterable<News> newsList = service.findAll();
    model.addAttribute("newsList", newsList);
    return template("index", model);
  }
}
