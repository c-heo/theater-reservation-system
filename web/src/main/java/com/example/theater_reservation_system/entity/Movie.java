package com.example.theater_reservation_system.entity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String title;
  private int genre;
  private Date period_start;
  private Date period_end;

  public String getGanre(){
    Map<Integer, String> ganreText = new HashMap<>();
    ganreText.put(1, "ジャンル1");
    ganreText.put(2, "ジャンル2");
    ganreText.put(3, "ジャンル3");
    return ganreText.get(genre);
  }
}
