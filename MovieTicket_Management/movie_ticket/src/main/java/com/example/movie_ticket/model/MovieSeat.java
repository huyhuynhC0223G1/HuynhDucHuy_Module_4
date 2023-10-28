package com.example.movie_ticket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MovieSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean seatStatus;

    @OneToOne
    private ShowtimeDetails showtimeDetails;

    @ManyToOne
    private Seat seat;

    public MovieSeat() {
    }

    public boolean getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }

    public ShowtimeDetails getShowtimeDetails() {
        return showtimeDetails;
    }

    public void setShowtimeDetails(ShowtimeDetails showtimeDetails) {
        this.showtimeDetails = showtimeDetails;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
