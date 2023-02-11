package duke.commands.tasks;

public abstract class Task {
    private static String DONE_MARK = "X";
    private static String UNDONE_MARK = " ";
    private static String REGEX = "~";
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this(description, false);
    }

    public Task(String description, boolean isDone) {
        this.description = description.trim();
        this.isDone = isDone;
    }

    public abstract String getTaskClass();

    /**
     * Gets the description of this task.
     *
     * @return A String representing the description of this task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Generates a String to store this task in a local text file.
     *
     * @return A representative String that contains data about the current task.
     */
    public String generateStorageText() {
        return String.format("%s" + Task.REGEX + "%s" + Task.REGEX + "%s",
                this.getTaskClass(),
                this.getStatusIcon(),
                this.getDescription());
    }

    protected String getStatusIcon() {
        return (this.isDone ? Task.DONE_MARK : Task.UNDONE_MARK); // mark done task with X
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markUndone() {
        this.isDone = false;
    }

    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }
}
