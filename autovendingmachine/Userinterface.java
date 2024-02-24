package edu.bu.met.cs665.autovendingmachine;

import java.util.Locale;
import java.util.Scanner;

public class Userinterface {
    private VendingMachine vendingMachine;
    private Scanner scanner;

    public Userinterface(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // A simple user interaction loop
        while (true) {
            System.out.println("Please select a beverage (Tea/Coffee) or type 'exit' to quit:");
            String category = scanner.nextLine().toLowerCase(Locale.ROOT);
            if ("exit".equalsIgnoreCase(category)) {
                break;
            }
            System.out.println("Please select the type or type 'exit' to quit:");
            String type = scanner.nextLine();
            if ("exit".equalsIgnoreCase(type)) {
                break;
            }

            AbstractBeverage orderedBeverage = vendingMachine.orderBeverage(category, type);

            if (orderedBeverage != null) {
                if ("coffee".equalsIgnoreCase(category)) {
                    handleCoffeeCondiments(orderedBeverage);
                }
                System.out.println("Your " + orderedBeverage.getDescription() + " is ready.");
            } else {
                System.out.println("No such beverage type available.");
            }
        }
    }

    private void handleCoffeeCondiments(AbstractBeverage beverage) {
        if (!(beverage instanceof Coffee)) {
            throw new IllegalArgumentException("The beverage is not a coffee.");
        }
        Coffee coffee = (Coffee) beverage;

        System.out.println("How many units of sugar do you want? (0-3)");
        int sugarUnits = getIntInput();
        while (sugarUnits > 3) {
            System.out.println("You can only add up to 3 units of sugar. Please re-enter:");
            sugarUnits = getIntInput();
        }
        for(int i = 0; i < sugarUnits; i++){
            coffee.addCondiments(new WhiteSugar());
        }


        System.out.println("How many units of milk do you want? (0-3)");
        int milkUnits = getIntInput();
        while (milkUnits > 3) {
            System.out.println("You can only add up to 3 units of milk. Please re-enter:");
            milkUnits = getIntInput();
        }
        for(int i = 0; i < milkUnits; i++){
            coffee.addCondiments(new WholeMilk());
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not an integer. Please enter an integer.");
            scanner.next(); // Clear the incorrect input
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line
        return number;
    }

}
