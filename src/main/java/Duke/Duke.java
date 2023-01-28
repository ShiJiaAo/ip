package Duke;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

import Duke.Commands.Tasks.Deadline;
import Duke.Commands.Tasks.Event;
import Duke.Commands.Tasks.Task;
import Duke.Commands.Tasks.ToDo;
import Duke.Commands.Parser;
import Duke.Commands.Command;
import Duke.Commands.Delete;
import Duke.Commands.Exit;
import Duke.Commands.Add;
import Duke.Commands.ListTasks;
import Duke.Commands.Unmark;
import Duke.Commands.Mark;

import Duke.dukeexception.DukeException;

/**
 * @author Shi Jiaao
 */

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke.Duke\n" +
                "What can I do for you?\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> toDoList = new ArrayList<>();
        while (true) {
            String command = sc.nextLine();
            Parser parser = new Parser(command);
            Command curCommand;
            try {
                curCommand = parser.process();
                curCommand.execute(toDoList);
            } catch (DukeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            curCommand.execute(toDoList);
            if (curCommand instanceof Exit) {
                break;
            }
            /*
            String[] commandArr = command.split(" ");
            int editIndex = Character.getNumericValue
                    (command.charAt(command.length() - 1)) - 1;
            switch (commandArr[0]) {
                case "list":
                    System.out.println(printList(toDoList));
                    break;
                case "mark":
                    toDoList.get(editIndex).markDone();
                    System.out.println("Nice! I've marked this task as done:\n" + "    " +
                            toDoList.get(editIndex));
                    break;
                case "unmark":
                    toDoList.get(editIndex).markUndone();
                    System.out.println("OK, I've marked this task as not done yet:\n" + "    " +
                            toDoList.get(editIndex));
                    break;
                case "todo":
                    String taskName = "";
                    for (int i = 1; i < commandArr.length; i++) {
                        taskName += commandArr[i] + " ";
                    }
                    taskName = taskName.trim();
                    try {
                        checkLength(taskName);
                    } catch (DukeException ex) {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        break;
                    }
                    Task toAdd = new ToDo(taskName);
                    toDoList.add(toAdd);
                    System.out.println(printTaskAdd(toAdd, toDoList));
                    break;
                case "deadline":
                    // separate with whitespace
                    // name -> go from start to /by
                    // time -> go from after /by to end
                    taskName = "";
                    int curInd = 1;
                    while (curInd < commandArr.length && !commandArr[curInd].equals("/by")) {
                        taskName += commandArr[curInd] + " ";
                        curInd += 1;
                    }
                    taskName = taskName.trim();
                    try {
                        checkLength(taskName);
                    } catch (DukeException ex) {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                        break;
                    }
                    curInd += 1; // skips "/by"
                    String taskDeadline = "";
                    while (curInd < commandArr.length) {
                        taskDeadline += commandArr[curInd] + " ";
                        curInd += 1;
                    }
                    taskDeadline = taskDeadline.trim();
                    toAdd = new Deadline(taskName, taskDeadline);
                    toDoList.add(toAdd);
                    System.out.println(printTaskAdd(toAdd, toDoList));
                    break;
                case "event":
                    taskName = "";
                    curInd = 1;
                    while (curInd < commandArr.length && !commandArr[curInd].equals("/from")) {
                        taskName += commandArr[curInd] + " ";
                        curInd += 1;
                    }
                    taskName = taskName.trim();
                    try {
                        checkLength(taskName);
                    } catch (DukeException ex) {
                        System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                        break;
                    }
                    curInd += 1;
                    String from = "";
                    while (curInd < commandArr.length && !commandArr[curInd].equals("/to")) {
                        from += commandArr[curInd] + " ";
                        curInd += 1;
                    }
                    from = from.trim();
                    curInd += 1;
                    String to = "";
                    while (curInd < commandArr.length) {
                        to += commandArr[curInd] + " ";
                        curInd += 1;
                    }
                    to = to.trim();
                    toAdd = new Event(taskName, from, to);
                    toDoList.add(toAdd);
                    System.out.println(printTaskAdd(toAdd, toDoList));
                    break;
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    sc.close();
                    return;
                case "delete":
                    System.out.println(String.format("Noted. I've removed this task:\n" +
                                    "    %s\n" +
                                    "Now you have %d tasks in the list.",
                            toDoList.get(editIndex), toDoList.size() - 1));
                    toDoList.remove(editIndex);
                    break;
                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
             */
        }
        sc.close();
    }
}
