package com.example.payback;

import com.example.payback.model.Meal;
import com.example.payback.repository.MealRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.Iterator;

@SpringBootApplication
public class PaybackApplication implements CommandLineRunner {

    @Autowired
    private MealRepository mealRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaybackApplication.class, args);
    }

    @Override
    public void run(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("meals.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray meals = (JSONArray) jsonObject.get("meals");

            Iterator<JSONObject> iterator = meals.iterator();
            while (iterator.hasNext()) {
                JSONObject mealObj = iterator.next();
                Meal meal = new Meal((String) mealObj.get("strMeal"), (String) mealObj.get("strArea"), (String) mealObj.get("strMealThumb"));
                mealRepository.save(meal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cool !");
    }

}
