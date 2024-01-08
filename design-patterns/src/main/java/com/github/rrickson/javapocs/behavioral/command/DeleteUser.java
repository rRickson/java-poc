package com.github.rrickson.javapocs.behavioral.command;

public class DeleteUser implements Command{
    @Override
    public void execute(Object context) {
        System.out.println("Deleting User");
    }

    @Override
    public boolean shouldRun(Object context) {
        return context.toString().contains("delete user");
    }
}
