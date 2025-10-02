import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Beta {
    private Ui ui;

    private TaskList tasks;
    private Storage storage;

    public Beta(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (BetaException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    public void run() {
        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {

            try {
                String fullCommand = ui.readCommand();
                String[] parsedCommand = Parser.parse(fullCommand);
                String command = parsedCommand[0];
                String inputBody = parsedCommand[1];

                switch (command) {
                case "list":
                    tasks.printTasks(ui);
                    break;
                case "mark":
                    tasks.markTask(Integer.parseInt(inputBody));
                    ui.showMessage("Nice! I've marked this task as done:\n" + tasks.get(Integer.parseInt(inputBody) - 1));
                    break;
                case "unmark":
                    tasks.unmarkTask(Integer.parseInt(inputBody));
                    ui.showMessage("Ok I've unmarked this task:\n" + tasks.get(Integer.parseInt(inputBody) - 1));
                    break;
                case "delete":
                    Task removedTask = tasks.deleteTask(Integer.parseInt(inputBody));
                    ui.showMessage("Alright. I've removed this task:\n" + removedTask);
                    break;
                case "todo":
                    Task todo = new Todo(inputBody);
                    tasks.addTask(todo);
                    ui.showMessage("Got it. I've added this todo:\n  " + todo + "\nNow you have " + tasks.getTasks().size() + " tasks in the list.");
                    break;
                case "deadline":
                    String[] deadlineParts = inputBody.split(" /by ", 2);
                    Task deadline = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                    tasks.addTask(deadline);
                    ui.showMessage("Alright. I've added this deadline:\n  " + deadline + "\nNow you have " + tasks.getTasks().size() + " tasks in the list.");
                    break;
                case "event":
                    String[] eventParts = inputBody.split(" /from | /to ");

                    if (eventParts.length < 3) {
                        throw new BetaException("Event format is invalid. Use: event <description> /from <start> /to <end>");
                    }

                    Task event = new Event(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
                    tasks.addTask(event);
                    ui.showMessage("Got it. I've added this event:\n  " + event + "\nNow you have " + tasks.getTasks().size() + " tasks in the list.");
                    break;
                case "find":
                    TaskList matchingTasks = tasks.findTasks(inputBody);

                    if (matchingTasks.size() == 0) {
                        ui.showMessage("Sorry, I couldn't find any tasks matching the keyword: '" + inputBody + "'.");
                    } else {
                        StringBuilder response = new StringBuilder("Here are the matching tasks in your list:\n");

                        for (int i = 0; i < matchingTasks.size(); i++) {
                            response.append(String.format("%d. %s\n", i + 1, matchingTasks.get(i)));
                        }
                        ui.showMessage(response.toString());
                    }
                    break;
                case "bye":
                    isExit = true;
                    break;
                default:
                    ui.showError("Hmmmmmmm. I don't know what that means. Try 'todo', 'list', or 'bye'!");
                }

                if (!isExit) {
                    try {
                        storage.save(tasks.getTasks());
                    } catch (BetaException e) {
                        ui.showError("WARNING: Task failed to save: " + e.getMessage());
                    }
                }

            } catch (BetaException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("An unexpected error occurred: " + e.getMessage());
            }
        }

        ui.showExitMessage();
    }


    public static void main(String[] args) {

        new Beta("data/Beta.txt").run();
    }

}
