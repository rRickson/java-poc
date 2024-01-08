package com.github.rrickson.javapocs.behavioral.chain_of_responsibility;

import java.util.Objects;

public class UserAvailabilityHandler implements Handler{

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
        Boolean available = Objects.equals(context.toString(), "chain_of_responsibility");
        if(null!=next) next.run(available);
        else System.out.printf("\nEnd of Chain, feature available = %s", available);

    }

}
