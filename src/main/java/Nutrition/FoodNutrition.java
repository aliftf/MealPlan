/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nutrition;

/**
 *
 * @author alift
 */
public class FoodNutrition extends Nutrition {


    @Override
    public void setNutrition() {

    }

    public void setNutrition(int calories, int protein, int carbs, int fat){
        if(calories < 0&& protein < 0 && carbs < 0 && fat < 0){
            System.out.println("Invalid Nutrition");
        }else{
            this.calories = calories;
            this.protein = protein;
            this.carbs = carbs;
            this.fat = fat;
        }
    }

    @Override
    public void displayNutrition(){
        System.out.println("\nFood Nutrition: ");
        System.out.printf("Calories: %d\n", this.calories);
        System.out.printf("Carbs: %d\n", this.carbs);
        System.out.printf("Fat: %d\n", this.fat);
        System.out.printf("Protein: %d\n", this.protein);
    }
}
