package com.example.mvcchart.model;

public class Parameters {
    private static Parameters parameters;
    private double a = 1;
    private double b = 1;

    private Parameters() {
    }

    public synchronized static Parameters getInstance() {
        if (parameters == null) parameters = new Parameters();
        return parameters;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
