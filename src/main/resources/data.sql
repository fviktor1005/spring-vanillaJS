DROP TABLE IF EXISTS MEALS;

CREATE TABLE MEALS (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              strArea VARCHAR(250) NOT NULL,
                              strMeal VARCHAR(250) NOT NULL,
                              strMealThumb VARCHAR(250) DEFAULT NULL
);