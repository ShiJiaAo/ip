package Duke.Commands;

import Duke.Commands.Tasks.Task;
import Duke.TaskList;

import java.util.ArrayList;

public class Delete extends Command {
    private final int index;
    private Task removed;
    private int newSize;
    public Delete(String message, int index) {
        super(message);
        this.index = index;
        this.removed = null;
        this.newSize = 0;
    }

    @Override
    public void execute(TaskList toDoList) {
        this.removed = toDoList.get(this.index);
        this.newSize = toDoList.size() - 1;
        toDoList.remove(this.index);
    }

    @Override
    public String toString() {
        return String.format("Noted. I've removed this task:\n" +
                "    %s\n" + "Now you have %d tasks in the list.",
                this.removed, this.newSize);
    }
}
