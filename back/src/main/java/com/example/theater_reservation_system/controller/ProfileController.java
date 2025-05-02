package com.example.theater_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater_reservation_system.service.UserService;
import com.example.theater_reservation_system.entity.User;


@Controller
public class ProfileController extends BaseController {

  private final UserService service;

  @Autowired
  public ProfileController(UserService service) {
    this.service = service;
  }

  @RequestMapping("/profile")
  public String getProfile(Model model) {
    User user = service.findLoginUser();
    model.addAttribute("user", user);
    return template("profile/show", model, "プロフィール");
  }

  @RequestMapping("/profile/edit")
  public String getProfileEdit(Model model) {
    User user = service.findLoginUser();
    model.addAttribute("user", user);
    return template("profile/edit", model, "プロフィール");
  }

  @RequestMapping("/profile/update")
  public String updateProfile(
    @RequestParam("username") String username,
    @RequestParam("email") String email,
    @RequestParam("points") int points,
    RedirectAttributes redirectAttributes
  ) {
    service.updateProfile(username, email, points);
    redirectAttributes.addFlashAttribute("updated", true);
    return "redirect:/profile";
  }
}
