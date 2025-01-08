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
@Table(name = "notifications")
@Getter
@Setter
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String user_id;
  private String text;
  private Boolean checked;
  private Date created_at;
}
