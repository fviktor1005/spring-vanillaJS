package com.example.payback.controller;

import com.example.payback.model.Meal;
import com.example.payback.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    private MealRepository mealRepository;

    @PostMapping("/meals")
    @ResponseStatus(HttpStatus.CREATED)
    public Meal create(@RequestBody Meal meal) {
        return mealRepository.save(meal);
    }

    @CrossOrigin
    @RequestMapping("/meals")
    public ResponseEntity<List<Meal>> getMeals() {
       return ResponseEntity.ok(mealRepository.findAll());
    }

    @CrossOrigin
    @RequestMapping("/meals/{searchStr}")
    public ResponseEntity<List<Meal>> findMeals(@PathVariable String searchStr) {
        return ResponseEntity.ok(mealRepository.findMealByStrMealContainingIgnoreCase(searchStr));
    }

}