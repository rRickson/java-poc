package com.github.rrickson.javapocs.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class UpdateUserWorkflow {

    public static List<Command> commands(){
        List<Command> queue = new ArrayList<>();
        queue.add(new SaveReportCommand());
        queue.add(new MarkAsInactive());
        queue.add(new DeleteUser());
        return queue;
    }
    public static void run(List<Command> commands, Object args){
        for(Command command : commands){
            if(command.shouldRun(args)) command.execute(args);
        }
    }
}
