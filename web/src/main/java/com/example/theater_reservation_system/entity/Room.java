package com.example.theater_reservation_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String theater_id;
  private int seats_count;
  private String seats;
}
