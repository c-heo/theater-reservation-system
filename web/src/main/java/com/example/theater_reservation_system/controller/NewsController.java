package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.repository.NewsRepository;
import com.example.theater_reservation_system.entity.News;


@Controller
public class NewsController extends BaseController {

  private final NewsRepository repository;

  @Autowired
  public NewsController(NewsRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/news")
  public String getMovies(Model model) {
    Iterable<News> theaters = repository.findAll();
    model.addAttribute("news", theaters);
    return template("news/index", model);
  }
}
