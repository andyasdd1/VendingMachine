package edu.bu.met.cs665.autovendingmachine;

public class Teafactory implements TeaInterface{
    @Override
    public Tea createTea(String type) {
        switch (type) {
            case "Green":
                return new GreenTea();
            case "Black":
                return new BlackTea();
            case "Yellow":
                return new YellowTea();
            default:
                throw new IllegalArgumentException("Unknown Tea Type");
        }
    }
}
