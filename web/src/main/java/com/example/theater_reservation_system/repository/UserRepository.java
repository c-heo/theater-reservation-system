package com.example.theater_reservation_system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.theater_reservation_system.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
