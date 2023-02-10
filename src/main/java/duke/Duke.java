package duke;

import java.util.Scanner;

import duke.commands.Command;
import duke.commands.Exit;
import duke.commands.Parser;
import duke.dukeexception.DukeException;



/**
 * This is the main class of the program.
 *
 * @author Shi Jia Ao
 */
public class Duke {
    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    protected String getResponse(String input) {
        return "Duke heard: " + input;
    }

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printWelcome();
        Storage storage = new Storage("data");
        TaskList toDoList;
        try {
            toDoList = storage.initialise();
        } catch (DukeException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            Parser parser = new Parser(command);
            Command curCommand;
            try {
                curCommand = parser.process();
                curCommand.execute(toDoList);
                ui.printCommandMessage(curCommand);
            } catch (DukeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            if (curCommand instanceof Exit) {
                ui.printGoodbye();
                storage.update(toDoList);
                break;
            }
        }
        sc.close();
    }
}
