package com.github.rrickson.javapocs.behavioral.chain_of_responsibility;

import java.util.Objects;

public class FeatureHandler implements Handler{

    private Handler next;

    @Override
    public void setNext(Handler next){
        if(null == this.next){
            this.next=next;
        }else{
            this.next.setNext(next);
        }
    }

    @Override
    public void run(Object context){
        boolean available = (Boolean) context;
        if(available){
            if(null!=next) next.run("chain_of_responsibility");
        }else{
            System.out.println("\nFeature Disabled");
        }
    }
}
