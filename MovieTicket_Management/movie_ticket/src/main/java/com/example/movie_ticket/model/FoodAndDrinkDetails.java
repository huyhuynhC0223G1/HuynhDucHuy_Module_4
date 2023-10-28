package com.example.movie_ticket.model;

import javax.persistence.*;

@Entity

public class FoodAndDrinkDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @ManyToOne
    private FoodAndDrink foodAndDrink;

    public FoodAndDrinkDetails(){

    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FoodAndDrink getFoodAndDrink() {
        return foodAndDrink;
    }

    public void setFoodAndDrink(FoodAndDrink foodAndDrink) {
        this.foodAndDrink = foodAndDrink;
    }
}
