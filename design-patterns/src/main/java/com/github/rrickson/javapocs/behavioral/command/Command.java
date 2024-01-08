package com.github.rrickson.javapocs.behavioral.command;

public interface Command {
    void execute(Object context);
    boolean shouldRun(Object context);
}
