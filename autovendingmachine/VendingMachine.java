package edu.bu.met.cs665.autovendingmachine;

public class VendingMachine {
    private  Teafactory teaFactory;
    private  CoffeeFactory coffeeFactory;

    public VendingMachine(Teafactory teafactory, CoffeeFactory coffeefactory){
        this.coffeeFactory = coffeefactory;
        this.teaFactory = teafactory;
    }

    public AbstractBeverage orderBeverage(String category, String type){
        if (type.equalsIgnoreCase("Tea")) {
            return teaFactory.createTea(category);
        } else if (type.equalsIgnoreCase("Coffee")) {
            return coffeeFactory.createCoffee(category);
        } else {
            System.out.println("Invalid beverage type selected.");
            return null;
        }
    }

}
