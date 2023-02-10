package duke.commands;

import duke.TaskList;

/**
 * This class is an abstract class representing all commands.
 */
public abstract class Command {
    // message is the command input
    private final String message;

    /**
     * Creates a new command class.
     *
     * @param message The exact message from the user to be treated as a command.
     */
    public Command(String message) {
        this.message = message;
    }

    /**
     * Executes this command.
     *
     * @param toDoList The task list to be edited.
     */
    public abstract void execute(TaskList toDoList);
}
