package com.example.theater_reservation_system.entity;

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
@Table(name = "theaters")
@Getter
@Setter
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private int area;
  private String access;

  public String getArea(){
    Map<Integer, String> areaText = new HashMap<>();
    areaText.put(1, "関東");
    areaText.put(2, "近畿");
    areaText.put(3, "九州");
    return areaText.get(area);
  }
}
