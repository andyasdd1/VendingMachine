package edu.bu.met.cs665.autovendingmachine;

public class BlackTea extends Tea{
    public BlackTea() {
        super("Black Tea", 1.25);
    }

    @Override
    public double getCost() {
        return this.baseCost;
    }
}
