/*from Junit test course: Practical Java Unit Testing with JUnit 5
 on udemy
* By Adrian Wiech
* */
package com.healthycoderapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setUp(){
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @Test
    void shouldReturnDietPlanWhenCoder(){
        //given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);
        //when
        DietPlan actualDietPlan = dietPlanner.calculateDiet(coder);
        //then
        assertAll(
                () -> assertEquals(expectedDietPlan.getCalories(), actualDietPlan.getCalories()),
                () -> assertEquals(expectedDietPlan.getProtein(), actualDietPlan.getProtein()),
                () -> assertEquals(expectedDietPlan.getCarbohydrate(), actualDietPlan.getCarbohydrate())
        );
    }

}