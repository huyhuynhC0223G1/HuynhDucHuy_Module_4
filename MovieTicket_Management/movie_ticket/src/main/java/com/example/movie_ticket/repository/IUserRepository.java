package com.example.movie_ticket.repository;

import com.example.movie_ticket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
