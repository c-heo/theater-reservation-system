package com.example.theater_reservation_system.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private int seatColumn;
  private String seatRow;

  @Column(name="created_at", updatable=false)
  @CreatedDate
  private LocalDateTime createdAt;

  @ManyToOne
	@JoinColumn(name="user_id")
  private User user;
  
  @ManyToOne
	@JoinColumn(name="schedule_id")
  private Schedule schedule;
}
