package com.github.rrickson.javapocs.behavioral.strategy;

public class StrategyFactory {

    public static RouteStrategy resolve(String strategy){
        if(strategy.equals("walk")){
          return new WalkingStrategy();
        }
        if(strategy.equals("car")){
            return new CarStrategy();
        }
        if(strategy.equals("plane")){
            return new PlaneStrategy();
        }
        return new WalkingStrategy();
    }
}
