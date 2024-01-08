package com.github.rrickson.javapocs.behavioral.strategy;

public class WalkingStrategy  implements RouteStrategy{
    @Override
    public void calculate(Object context) {
        int time = (Integer) context;
        System.out.printf("Calculating Walking time %s\n", time*1.9);
    }
}
