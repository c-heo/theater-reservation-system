package com.example.theater_reservation_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.News;
import com.example.theater_reservation_system.repository.NewsRepository;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  public Iterable<News> findAll() {
    Iterable<News> newsList = newsRepository.findAll();
    return newsList;
  }

  public News findById(UUID id){
    News news = newsRepository.findById(id);
    return news;
  }
}
