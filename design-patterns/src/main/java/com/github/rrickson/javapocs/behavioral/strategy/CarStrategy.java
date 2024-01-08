package com.github.rrickson.javapocs.behavioral.strategy;

public class CarStrategy implements RouteStrategy{
    @Override
    public void calculate(Object context) {

        int time = (Integer) context;
        System.out.printf("Calculating Car time %s\n", time*1.6);
    }
}
