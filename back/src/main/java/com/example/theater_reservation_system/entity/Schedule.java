package com.example.theater_reservation_system.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
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

  @Column(name="movie_id")
  private UUID movieId;

  @Column(name="room_id")
  private UUID roomId;

  private LocalDateTime startAt;
  private LocalDateTime endAt;
  
  @ManyToOne
	@JoinColumn(name="movie_id", insertable=false, updatable=false)
  private Movie movie;
  
  @ManyToOne
	@JoinColumn(name="room_id", insertable=false, updatable=false)
  private Room room;
}
