package com.example.movie_ticket.repository;

import com.example.movie_ticket.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowtimeRepository extends JpaRepository<Showtime, Long> {

}
