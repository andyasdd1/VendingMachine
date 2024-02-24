package edu.bu.met.cs665;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.bu.met.cs665.autovendingmachine.Americano;
import edu.bu.met.cs665.autovendingmachine.BlackTea;
import edu.bu.met.cs665.autovendingmachine.CoffeeFactory;
import edu.bu.met.cs665.autovendingmachine.CoffeeInterface;
import edu.bu.met.cs665.autovendingmachine.Coffee;
import edu.bu.met.cs665.autovendingmachine.Condiments;
import edu.bu.met.cs665.autovendingmachine.Espresso;
import edu.bu.met.cs665.autovendingmachine.GreenTea;
import edu.bu.met.cs665.autovendingmachine.LatteMacchiato;
import edu.bu.met.cs665.autovendingmachine.Milk;
import edu.bu.met.cs665.autovendingmachine.Sugar;
import edu.bu.met.cs665.autovendingmachine.Teafactory;
import edu.bu.met.cs665.autovendingmachine.Tea;
import edu.bu.met.cs665.autovendingmachine.TeaInterface;
import edu.bu.met.cs665.autovendingmachine.Userinterface;
import edu.bu.met.cs665.autovendingmachine.VendingMachine;
import edu.bu.met.cs665.autovendingmachine.WhiteSugar;
import edu.bu.met.cs665.autovendingmachine.WholeMilk;
import edu.bu.met.cs665.autovendingmachine.YellowTea;
class VendingMachineTest {

    @Test
    void testCoffeeCreation() {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee("Espresso");
        assertNotNull(coffee);
        assertEquals("Espresso", coffee.getDescription());
    }

    @Test
    void testTeaCreation() {
        Teafactory teaFactory = new Teafactory();
        Tea tea = teaFactory.createTea("Green");
        assertNotNull(tea);
        assertEquals("Green Tea", tea.getDescription());
    }

    @Test
    void testCoffeeCondimentAddition() {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee("Espresso");
        Condiments milk = new WholeMilk();
        Condiments sugar = new WhiteSugar();

        for (int i = 0; i < 3; i++) {
            coffee.addCondiments(milk);
            coffee.addCondiments(sugar);
        }

        String description = coffee.getDescription();
        assertTrue(description.contains("Whole Milk"));
        assertTrue(description.contains("White Sugar"));
        // Check if the description contains only up to 3 units of each condiment
    }

    @Test
    void testCondimentLimit() {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee("Espresso");
        Condiments milk = new WholeMilk();
        Condiments sugar = new WhiteSugar();
        Exception exception = null;

        for (int i = 0; i < 4; i++) { // add 4 units
            coffee.addCondiments(milk);
            coffee.addCondiments(sugar);
        }


        int milkCount = coffee.getCondimentsnumber().get("Sugar");
        int sugarCount = coffee.getCondimentsnumber().get("Milk");

        assertEquals(3, milkCount, "Milk count should not exceed 3");
        assertEquals(3, sugarCount, "Sugar count should not exceed 3");
    }

}
