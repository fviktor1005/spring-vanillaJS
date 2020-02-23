package com.example.payback.service;

import com.example.payback.model.Meal;
import com.example.payback.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> list() {
        return mealRepository.findAll();
    }


}
