package edu.bu.met.cs665.autovendingmachine;

public abstract class AbstractBeverage {
    protected String description;
    protected double baseCost;

    public AbstractBeverage(String description, double baseCost){
        this.description = description;
        this.baseCost = baseCost;

    }

    public String getDescription(){
        return  description;
    }

    public double getBaseCost(){
        return  baseCost;
    }

    public abstract  double getCost();


}
