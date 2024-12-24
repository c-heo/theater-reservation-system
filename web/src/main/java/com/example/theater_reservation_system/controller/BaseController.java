package com.example.theater_reservation_system.controller;

import org.springframework.ui.Model;

public class BaseController {
	public String template(String path, Model model) {
    model.addAttribute("isLogin", true);
    model.addAttribute("contentsPath", path);
    return "layout/layout";
	}

  public String templateWithoutLogin(String path, Model model) {
    model.addAttribute("isLogin", false);
    model.addAttribute("contentsPath", path);
    return "layout/layout_without_login";
	}
}
