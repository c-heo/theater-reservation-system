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
@Table(name = "schedules")
@Getter
@Setter
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private Date start_at;
  private Date end_at;
  
  @ManyToOne
	@JoinColumn(name="movie_id")
  private Movie movie;
  
  @ManyToOne
	@JoinColumn(name="room_id")
  private Room room;
}
