package edu.bu.met.cs665.autovendingmachine;

public class GreenTea extends Tea {
    public GreenTea() {
        super("Green Tea", 1.99);
    }

    @Override
    public double getCost() {
        return this.baseCost;
    }
}
