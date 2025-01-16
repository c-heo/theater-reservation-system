package com.example.theater_reservation_system.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String seat_column;
  private int seat_row;
  private Date created_at;
  
  @ManyToOne
	@JoinColumn(name="user_id")
  private User user;
  
  @ManyToOne
	@JoinColumn(name="schedule_id")
  private Schedule schedule;
}
