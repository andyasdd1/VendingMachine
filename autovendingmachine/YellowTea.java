package edu.bu.met.cs665.autovendingmachine;

public class YellowTea extends Tea{
    public YellowTea() {
        super("Yellow Tea", 2.15);
    }

    @Override
    public double getCost() {
        return this.baseCost;
    }
}
