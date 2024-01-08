package com.github.rrickson.javapocs.behavioral.chain_of_responsibility;

public class Main {
    public static void main(String[] args){
        Handler mainHandler = new FeatureHandler();
        mainHandler.setNext(new UserAvailabilityHandler());
        mainHandler.run(true);
        Handler secondHandler = new FeatureHandler();
        secondHandler.setNext(new UserAvailabilityHandler());
        mainHandler.run(false);
    }
}
