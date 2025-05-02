package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.theater_reservation_system.service.MovieService;
import com.example.theater_reservation_system.entity.Movie;


@Controller
public class MovieController extends BaseController {

  private final MovieService service;

  @Autowired
  public MovieController(MovieService service) {
    this.service = service;
  }

  @RequestMapping("/movies")
  public String getMovies(Model model, Pageable pageable) {
    Page<Movie> movies = service.getMovies(pageable);
    model.addAttribute("page", movies);
    model.addAttribute("movies", movies.getContent());
    return template("movies/index", model, "映画一覧");
  }

  @RequestMapping("/movie/{id:.+}")
  public String getMovie(Model model, @PathVariable("id") UUID movieId) {
    Movie movie = service.findById(movieId);
    model.addAttribute("movie", movie);
    return template("movies/show", model, "");
  }
}
