package com.github.rrickson.javapocs.behavioral.command;

public class Main {
    public static void main(String[] args){
        UpdateUserWorkflow.run(UpdateUserWorkflow.commands(), "clear");
        UpdateUserWorkflow.run(UpdateUserWorkflow.commands(), "delete user");
    }
}
