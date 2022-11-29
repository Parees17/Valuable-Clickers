package com.example.clickergame;

public class Valuable {

    private String name;
    private double value;
    private double timeInterval;

    public Valuable(String n, double v, int tI){
        name = n;
        value = v;
        timeInterval = tI;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double inp) {
        this.value = inp;
    }

    public String getName() {
        return name;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(double x) {
        timeInterval = x;
    }
}
