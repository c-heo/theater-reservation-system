package com.example.theater_reservation_system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Movie;
import com.example.theater_reservation_system.repository.MovieRepository;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public Iterable<Movie> findAll() {
    Iterable<Movie> movies = movieRepository.findAll();
    return movies;
  }

  public Movie findById(UUID id){
    Movie movie = movieRepository.findById(id);
    return movie;
  }
}
