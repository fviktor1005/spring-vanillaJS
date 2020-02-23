package com.example.payback.model;

import javax.persistence.*;

@Entity(name="MEAL")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String strMeal;
    private String strArea;
    private String strMealThumb;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Meal() {

    }

    public Meal(String strMeal, String strArea, String strMealThumb) {
        this.strMeal = strMeal;
        this.strArea = strArea;
        this.strMealThumb = strMealThumb;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
}
