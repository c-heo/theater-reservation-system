package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater_reservation_system.service.ScheduleService;
import com.example.theater_reservation_system.service.TicketService;
import com.example.theater_reservation_system.entity.Schedule;
import com.example.theater_reservation_system.entity.Ticket;

@Controller
public class TicketController extends BaseController {

  private final TicketService ticketService;
  private final ScheduleService scheduleService;

  @Autowired
  public TicketController(TicketService ticketService, ScheduleService scheduleService) {
    this.ticketService = ticketService;
    this.scheduleService = scheduleService;
  }

  @RequestMapping("/tickets")
  public String getTickets(
      Model model,
      @PageableDefault(page = 0, sort = "createdAt", direction = Direction.DESC) Pageable pageable
    ) {
    Page<Ticket> tickets = ticketService.findLoginUserTickets(pageable);
    model.addAttribute("page", tickets);
    model.addAttribute("tickets", tickets.getContent());
    return template("tickets/index", model, "チケット一覧");
  }

  @RequestMapping("/ticket/purchase")
  public String newTicket(@RequestParam("scheduleId") UUID scheduleId, Model model) {
    Schedule schedule = scheduleService.findById(scheduleId);
    model.addAttribute("schedule", schedule);
    return template("tickets/purchase", model, "チケット購入");
  }

  @RequestMapping("/ticket/create")
  public String createTicket(
    @RequestParam("scheduleId") UUID scheduleId,
    @RequestParam("seat_column") int seatColumn,
    @RequestParam("seat_row") String seatRow,
    RedirectAttributes redirectAttributes
  ) {
    ticketService.createTicket(scheduleId, seatColumn, seatRow);
    redirectAttributes.addFlashAttribute("created", true);
    return "redirect:/tickets";
  }

  @RequestMapping("/ticket/delete")
  public String deleteTicket(@RequestParam("id") UUID ticketId, RedirectAttributes redirectAttributes) {
    ticketService.deleteTicket(ticketId);
    redirectAttributes.addFlashAttribute("deleted", true);
    return "redirect:/tickets";
  }
}
