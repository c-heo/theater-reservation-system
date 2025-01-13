package com.example.theater_reservation_system.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class BaseController {
  public String template(String path, Model model) {
    Boolean isAuthenticated = !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    model.addAttribute("isAuthenticated", isAuthenticated);
    if(isAuthenticated) {
      model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
    }
    model.addAttribute("contentsPath", path);
    return "layout/layout";
  }
}
