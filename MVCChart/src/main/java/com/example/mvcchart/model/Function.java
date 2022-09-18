package com.example.mvcchart.model;

public class Function {
    private static Function function;

    private Function() {

    }

    public synchronized static Function getInstance() {
        if (function == null) function = new Function();
        return function;
    }

    public double getY(double x) {
       return Parameters.getInstance().getA()*x*x + Parameters.getInstance().getB();
    }
}
