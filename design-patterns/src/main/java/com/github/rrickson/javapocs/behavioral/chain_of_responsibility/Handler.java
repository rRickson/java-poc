package com.github.rrickson.javapocs.behavioral.chain_of_responsibility;

public interface Handler {
    void setNext(Handler next);
    void run(Object context);
}
