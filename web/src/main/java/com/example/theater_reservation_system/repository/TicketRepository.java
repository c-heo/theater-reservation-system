package com.example.theater_reservation_system.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.theater_reservation_system.entity.Ticket;

import jakarta.transaction.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
  public Ticket findById(UUID uuid);

  @Query("SELECT t FROM Ticket t INNER JOIN t.user t.schedule WHERE t.user.email = :email ORDER BY t.created_at DESC")
	public Page<Ticket> findByUserEmail(@Param("email") String email, Pageable pageable);

  @Transactional
  public void deleteById(UUID id);
}
