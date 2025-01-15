package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.service.NewsService;
import com.example.theater_reservation_system.entity.News;


@Controller
public class NewsController extends BaseController {

  private final NewsService service;

  @Autowired
  public NewsController(NewsService service) {
    this.service = service;
  }

  @RequestMapping("/news")
  public String getMovies(Model model) {
    Iterable<News> newsList = service.findAll();
    model.addAttribute("newsList", newsList);
    return template("news/index", model, "ニュース");
  }
}
