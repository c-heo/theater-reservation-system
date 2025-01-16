package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping("/news/{id:.+}")
  public String getNews(Model model, @PathVariable("id") UUID newsId) {
    News news = service.findById(newsId);
    model.addAttribute("news", news);
    return template("news/show", model, "");
  }
}
