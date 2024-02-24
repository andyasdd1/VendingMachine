package edu.bu.met.cs665.autovendingmachine;

public class Main {
    public static void main(String[] args) {
        // Initialize the VendingMachine
        Teafactory teafactory = new Teafactory();
        CoffeeFactory coffeeFactory = new CoffeeFactory();

        VendingMachine vendingMachine = new VendingMachine(teafactory, coffeeFactory);

        // Initialize the Userinterface with the VendingMachine instance
        Userinterface userInterface = new Userinterface(vendingMachine);

        // Start the user interaction loop
        userInterface.start();
    }
}
