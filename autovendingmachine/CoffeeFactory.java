package edu.bu.met.cs665.autovendingmachine;

public class CoffeeFactory implements CoffeeInterface{

    @Override
    public Coffee createCoffee(String type) {
        switch (type) {
            case "Espresso":
                return new Espresso();
            case "Americano":
                return new Americano();
            case "Latte Macchiato":
                return new LatteMacchiato();
            default:
                throw new IllegalArgumentException("Unknown Coffee Type");
        }
    }
}
