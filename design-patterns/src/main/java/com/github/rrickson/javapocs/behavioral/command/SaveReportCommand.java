package com.github.rrickson.javapocs.behavioral.command;

public class SaveReportCommand implements Command{

    @Override
    public void execute(Object context){
        System.out.println("Saving report on S3");
    }

    @Override
    public boolean shouldRun(Object context){
        return true;
    }
}
