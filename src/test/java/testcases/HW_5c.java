package testcases;

public class HW_5c {
    public static void main(String[] args) {

        String firstName = "Anastasia";
        int age = 50;
        int promotion = 20;
        String location = "'Queen St W #341, Toronto, ON M5V 2A4'";
        String shopName = "'Cucumber'";
      /*
        System.out.println("Happy Birthday ! Dear "+ firstName +", Special Birthday Offers for your "+ age +" !");
        System.out.println("Enjoy an extra "+ promotion +"% off on your entire purchase today !");
        System.out.println("Treat yourself to something you've had your eye on, and make your birthday celebration even sweeter.");
        System.out.println("Visit Us Today !Stop by our store at "+ location +" to avail yourself of these fantastic birthday promotions.");
        System.out.println("Our friendly staff is eagerly waiting to greet you and ensure you have an amazing shopping experience.");
        System.out.println("Please note that these offers are exclusively available for today, so don't miss out on this opportunity to indulge yourself on your special day.");
        System.out.println("We hope to make your birthday truly unforgettable! Once again, happy birthday from all of us at "+ shopName +"!");
        */

       int newCars = 50;
       int oldCars = 20;
       int hitCars = 2;
       int brokenCars = 1;

       int totalCars = newCars+oldCars+hitCars+brokenCars;
       System.out.println(totalCars);

       int profit = newCars*5 + oldCars*4 + (hitCars+brokenCars)*2;
       System.out.println(profit);

       int ratioOfNewCarsToOld = newCars/oldCars;
       System.out.println(ratioOfNewCarsToOld);

       int residual = newCars-oldCars;
       System.out.println(residual);
    }
}