package edu.bu.met.cs665.autovendingmachine;

public abstract class Condiments {
    protected String description;
    protected double baseCost;

    public Condiments(String description, double baseCost){
        this.description = description;
        this.baseCost = baseCost;

    }

    public String getDescription(){
        return  description;
    }

    public double getBaseCost(){
        return  baseCost;
    }
}
