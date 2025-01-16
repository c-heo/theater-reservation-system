package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater_reservation_system.service.MovieService;
import com.example.theater_reservation_system.service.TicketService;
import com.example.theater_reservation_system.entity.Movie;
import com.example.theater_reservation_system.entity.Ticket;

@Controller
public class TicketController extends BaseController {

  private final TicketService ticketService;
  private final MovieService movieService;

  @Autowired
  public TicketController(TicketService ticketService, MovieService movieService) {
    this.ticketService = ticketService;
    this.movieService = movieService;
  }

  @RequestMapping("/tickets")
  public String getTickets(Model model) {
    Iterable<Ticket> tickets = ticketService.findLoginUserTickets();
    model.addAttribute("tickets", tickets);
    return template("tickets/index", model, "チケット一覧");
  }

  @RequestMapping("/ticket/purchase")
  public String newTicket(@RequestParam("movieId") UUID movieId, Model model) {
    Movie movie = movieService.findById(movieId);
    model.addAttribute("movie", movie);
    return template("tickets/purchase", model, "チケット購入");
  }

  @RequestMapping("/ticket/delete")
  public String deleteTicket(@RequestParam("id") UUID ticketId, RedirectAttributes redirectAttributes) {
    ticketService.deleteTicket(ticketId);
    redirectAttributes.addFlashAttribute("deleted", true);
    return "redirect:/tickets";
  }
}
