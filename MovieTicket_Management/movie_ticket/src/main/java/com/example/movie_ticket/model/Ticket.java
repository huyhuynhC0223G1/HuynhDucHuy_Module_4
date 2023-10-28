package com.example.movie_ticket.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private User user;

    @OneToOne
    private ShowtimeDetails showtimeDetails;

    @OneToMany
    private List<FoodAndDrink> foodAndDrink;

    public Ticket() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShowtimeDetails getShowtimeDetails() {
        return showtimeDetails;
    }

    public void setShowtimeDetails(ShowtimeDetails showtimeDetails) {
        this.showtimeDetails = showtimeDetails;
    }

    public List<FoodAndDrink> getFoodAndDrink() {
        return foodAndDrink;
    }

    public void setFoodAndDrink(List<FoodAndDrink> foodAndDrink) {
        this.foodAndDrink = foodAndDrink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
