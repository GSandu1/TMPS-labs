package domain.commands;

import domain.interfaces.Command;
import java.util.Stack;

public class CommandInvoker {
    private Stack<Command> commandHistory;

    public CommandInvoker() {
        commandHistory = new Stack<>();
    }

    public void execute(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }

}
