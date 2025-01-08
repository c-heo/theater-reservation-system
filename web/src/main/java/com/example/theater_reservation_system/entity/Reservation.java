package com.example.theater_reservation_system.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String user_id;
  private String schedule_id;
  private String seat_column;
  private int seat_row;
  private Date created_at;
}
