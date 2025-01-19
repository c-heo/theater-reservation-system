package com.example.theater_reservation_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.theater_reservation_system.entity.Room;
import com.example.theater_reservation_system.entity.Schedule;
import com.example.theater_reservation_system.repository.ScheduleRepository;

import jakarta.persistence.criteria.JoinType;

@Service
public class ScheduleService {

  @Autowired
  ScheduleRepository scheduleRepository;

  public Schedule findById(UUID id){
    Schedule schedule = scheduleRepository.findById(id);
    return schedule;
  }

  public Page<Schedule> searchSchedules(UUID movieId, UUID theaterId, Pageable pageable) {
    // 検索条件の設定
    Specification<Schedule> specification = Specification.where(joinRoom());
    if(movieId != null) specification = specification.and(equalMovieId(movieId));
    if(theaterId != null) specification = specification.and(equalTheaterId(theaterId));

    // 検索
    Page<Schedule> schedules = scheduleRepository.findAll(specification, pageable);
    return schedules;
  }

  private Specification<Schedule> equalMovieId(UUID movieId) {
    return (root, query, builder) -> {
        return builder.equal(root.get("movieId"), movieId);
    };
  }

  private Specification<Schedule> joinRoom() {
      return (root, query, builder) -> {
          root.fetch("room", JoinType.INNER);
          return null;
      };
  }

  private Specification<Schedule> equalTheaterId(UUID theaterId) {
    return (root, query, builder) -> {
        return builder.equal(root.<List<Room>>get("room").get("theaterId"), theaterId);
    };
  }
}
