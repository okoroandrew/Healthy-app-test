package com.healthycoderapp;

/*from Junit test course: Practical Java Unit Testing with JUnit 5
 on udemy
* By Adrian Wiech
* */
public class DietPlan {
	private int calories;
	private int protein;
	private int fat;
	private int carbohydrate;
	
	public DietPlan(int calories, int protein, int fat, int carbohydrate) {
		super();
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbohydrate = carbohydrate;
	}
	
	@Override
	public String toString() {
		return "Diet [calories=" + calories + ", protein=" + protein + ", fat=" + fat + ", carbohydrate="
				+ carbohydrate + "]";
	}

	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
	public int getFat() {
		return fat;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public int getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
}
