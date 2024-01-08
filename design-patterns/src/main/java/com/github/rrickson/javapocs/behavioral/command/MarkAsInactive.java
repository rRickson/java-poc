package com.github.rrickson.javapocs.behavioral.command;

public class MarkAsInactive implements  Command{
    @Override
    public void execute(Object context) {
        System.out.println("Marking user as Inactive");
    }

    @Override
    public boolean shouldRun(Object context) {
        return true;
    }
}
