package com.github.rrickson.javapocs.behavioral.strategy;

public class PlaneStrategy implements RouteStrategy{
    @Override
    public void calculate(Object context) {
        int time = (Integer) context;
        System.out.printf("Calculating Plane time %s\n", time*1.3);
    }
}
