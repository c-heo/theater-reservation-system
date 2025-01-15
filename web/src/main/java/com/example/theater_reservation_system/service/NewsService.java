package com.example.theater_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.News;
import com.example.theater_reservation_system.repository.NewsRepository;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  public Iterable<News> findAll() {
    Iterable<News> news = newsRepository.findAll();
    return news;
  }
}
