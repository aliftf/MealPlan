/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Interface.Loginable;
import Meal.Meal;
import Meal.Recipe;
import Schedule.ScheduleList;
import Nutrition.UserNutrition;
import java.util.Scanner;

/**
 *
 * @author alift
 */
public class User implements Loginable {
    enum Gender{
        Male,
        Female
    }
    
    private String username = "michael";
    private String password = "12345678";
    private String name;
    private String email;
    private Gender gender;
    private int age;
    private int height;
    private int weight;
    private boolean loginStatus;
    private ScheduleList scheduleList;
    private Meal recipes;
    private UserNutrition userNutrition;
    Scanner scanner = new Scanner(System.in);
    
    public User(){
        scheduleList = new ScheduleList();
        recipes = new Meal();
        userNutrition = new UserNutrition();
    }
    
    public void register(){
        String username, password, name, email, gender;
        int age, height, weight;
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        System.out.print("E-mail: ");
        email = scanner.nextLine();
        System.out.print("Gender (Male/Female): ");
        gender = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        System.out.print("Height: ");
        height = scanner.nextInt();
        System.out.print("Weight: ");
        weight = scanner.nextInt();
        
        
        if(username.length()>0 && password.length()>=8){
            this.username = username;
            this.password = password;
            this.name = name;
            this.email = email;
            this.gender = Gender.valueOf(gender);
            this.age = age;
            this.height = height;
            this.weight = weight;
            System.out.println("Registration successfull");
        }else{
            System.out.println("Registration failed");
        }
    }
    
    public boolean login(){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if(this.username.equals(username)&&this.password.equals(password)){
            System.out.printf("Login successfull\nWelcome %s\n",name);
            loginStatus = true;
            return true;
        }else{
            System.out.println("Login failed");
            return false;
        }
    }
    public void changeUsername(){
        System.out.print("CHANGE USERNAME\nEnter new username: ");
        String temp = scanner.nextLine();
        if(temp.length()>4){
            this.username = temp;
            System.out.println("Change username successfull");
        }else{
            System.out.println("Username invalid");
        }
    }
    
    public void changePassword(){
        System.out.print("CHANGE PASSWORD\nEnter old password: ");
        String temp = scanner.nextLine();
        if(this.password.equals(temp)){
            System.out.print("Enter new password");
            temp = scanner.nextLine();
            if(temp.length() >= 8){
                this.password = temp;
            }else{
                System.out.println("Minimum 8 character");
            }
        }else{
            System.out.println("Wrong password");
        }
    }
    
    public void changeName(){
        System.out.print("CHANGE NAME\nEnter new name: ");
        String temp = scanner.nextLine();
        if(temp.length()>0){
            this.name = temp;
            System.out.println("Change name successfull");
        }else{
            System.out.println("name invalid");
        }
    }
    
    public void changeEmail(){
        System.out.print("CHANGE E-MAIL\nEnter new e-mail: ");
        String temp = scanner.nextLine();
        if(temp.contains("@")){
            this.email = temp;
            System.out.println("Change e-mail successfull");
        }else{
            System.out.println("e-mail invalid");
        }
    }
    
    public void changeGender(){
        System.out.print("CHANGE GENDER\nEnter new gender: ");
        String temp = scanner.nextLine();
        if(temp.equals("Male") || temp.equals("Female")){
            this.gender = Gender.valueOf(temp);
            System.out.println("Change gender successfull");
        }else{
            System.out.println("gender invalid");
        }
    }

    public void changeAge(){
        System.out.print("CHANGE AGE\nEnter new age: ");
        int temp = scanner.nextInt();
        if(temp > 0){
            this.age = temp;
            System.out.println("Change age successfull");
        }else{
            System.out.println("Age invalid");
        }
    }
    
    public void changeHeightWeight(){
        System.out.print("CHANGE HEIGHT\nEnter new height: ");
        int temp = scanner.nextInt();
        if(temp > 0){
            this.height = temp;
            System.out.println("Change height successfull");
        }else{
            System.out.println("Height invalid");
        }
        
        System.out.print("CHANGE WEIGHT\nEnter new username: ");
        temp = scanner.nextInt();
        if(temp > 0){
            this.weight = temp;
            System.out.println("Change weight successfull");
        }else{
            System.out.println("weight invalid");
        }
    }
    
    public void createSchedule(Meal meal){
        System.out.println("CREATE SCHEDULE");
        scheduleList.addSchedule(meal);
    }
    
    public void showScheduleRecipeName(){
        scheduleList.showScheduleRecipeName();
    }

    public void addRecipe(){
        recipes.addRecipeInput();
    }

    public void searchRecipe(Meal meal){
        System.out.print("Enter recipe name to search: ");
        String search = scanner.nextLine();
        if(meal.searchRecipe(search)!=null){
            meal.searchRecipe(search).showRecipeDetails();
        }
        if(recipes.searchRecipe(search)!=null){
            recipes.searchRecipe(search).showRecipeDetails();
        }
    }

    public void showRecipe(Meal meal){
        System.out.println("RECIPES\n");
        recipes.showRecipeName();
        for(Recipe recipe: meal.getRecipes()){
            System.out.println(recipe.getRecipeName());
        }
    }

    public void removeRecipe(){
        System.out.print("Enter recipe name to remove: ");
        String search = scanner.nextLine();
        Recipe remove = recipes.searchRecipe(search);
        if(remove!=null){
            recipes.removeRecipe(remove);
        }
    }

    public void showScheduleDetails(){
        scheduleList.showScheduleDetails();
    }
    
    public void removeSchedule(){
        scheduleList.removeSchedule();
    }
    
    public void removeScheduleRecipe(){
        scheduleList.removeScheduleRecipe();
    }
    
    public void showProfile(){
        System.out.printf("Name: %s\n",name);
        System.out.printf("Username: %s\n", username);
        System.out.printf("Email: %s\n\n", email);
    }

    public void setNutrition(User user){
        userNutrition.setNutrition(user);
    }
    public void displayNutritionNeed(){
        userNutrition.displayNutrition();
    }
    public String getGender() {
        return gender.toString();
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
