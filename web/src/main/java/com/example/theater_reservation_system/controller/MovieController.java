package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.repository.MovieRepository;
import com.example.theater_reservation_system.entity.Movie;


@Controller
public class MovieController extends BaseController {

  private final MovieRepository repository;

  @Autowired
  public MovieController(MovieRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/movies")
  public String getMovies(Model model) {
    Iterable<Movie> movies = repository.findAll();
    model.addAttribute("movies", movies);
    return template("movies/index", model);
  }
}
