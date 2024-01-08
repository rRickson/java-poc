package com.github.rrickson.javapocs.behavioral.strategy;

public class Main {
    public static void main(String[] args){
        String strategyType = "walk";
        RouteStrategy strategy = StrategyFactory.resolve(strategyType);
        strategy.calculate(5);
        strategyType = "car";
        RouteStrategy strategyCar = StrategyFactory.resolve(strategyType);
        strategyCar.calculate(5);
        strategyType = "plane";
        RouteStrategy strategyPlane = StrategyFactory.resolve(strategyType);
        strategyPlane.calculate(5);
    }
}
