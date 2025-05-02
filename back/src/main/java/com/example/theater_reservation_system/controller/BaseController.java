package com.example.theater_reservation_system.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class BaseController {
  public String template(String path, Model model, String titleText) {
    // ログイン判定
    Boolean isAuthenticated = !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    model.addAttribute("isAuthenticated", isAuthenticated);
    if(isAuthenticated) {
      model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
    }

    // bodyで表示するtemplateのパス指定
    model.addAttribute("contentsPath", path);

    // titleタグの文字列設定
    String title = "映画予約システム";
    if(titleText != ""){
      title += " - " + titleText;
    }
    model.addAttribute("title", title);
    return "layout/layout";
  }
  
  // タイトルの文字をデフォルトにする場合のオーバーロード用
  public String template(String path, Model model) {
    return template(path, model, "");
  }
}
