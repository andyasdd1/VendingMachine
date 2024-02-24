package edu.bu.met.cs665.autovendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Coffee extends AbstractBeverage{
    public Coffee(String description, double baseCost) {
        super(description, baseCost);
    }
    private static final  int maxcondimentunits = 3;
    private List<Condiments> addedCondiments = new ArrayList<>();
    private Map<Class<? extends Condiments>, Integer> condimentCounts = new HashMap<>();
    public void addCondiments(Condiments condiment){

        condimentCounts.merge(condiment.getClass(), 1, Integer::sum);
        if(condimentCounts.get(condiment.getClass()) <= maxcondimentunits){
            addedCondiments.add(condiment);
            System.out.println("Added " + condiment.getDescription());
        }else {
            System.out.println("Cannot add more than 3 units of " + condiment.getDescription());
            // Optionally, remove the last increment since it exceeds the limit
            condimentCounts.put(condiment.getClass(), 3);
        }
    }

    public Map<String,Integer> getCondimentsnumber(){
        int sugarnum = 0;
        int milknum = 0;
        Map<String,Integer> codiments = new HashMap<>();
        for(int i = 0; i < addedCondiments.size(); i ++){
            if(addedCondiments.get(i) instanceof WholeMilk ){
                milknum++;
            } else if (addedCondiments.get(i) instanceof WhiteSugar) {
                sugarnum++;
            }

        }
        codiments.put("Sugar", sugarnum);
        codiments.put("Milk",milknum);
        return codiments;
    }
    @Override
    public String getDescription() {
        StringBuilder fullDescription = new StringBuilder(super.getDescription());
        for (Condiments condiment : addedCondiments) {
            fullDescription.append(", ").append(condiment.getDescription());
        }
        return fullDescription.toString();
    }

    @Override
    public double getCost() {
        double totalCost = super.getBaseCost();
        for (Condiments condiment : addedCondiments) {
            totalCost += condiment.getBaseCost();
        }
        return totalCost;
    }
}
