package com.example.movie_ticket.service;

import com.example.movie_ticket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserService {
    void save(User user);
}
