import java.util.Scanner;
import java.util.Arrays;

public class Beta {

    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        greetUser();

        while (true) {
            String line = in.nextLine();
            if (line.equals("bye")) break;

            try {
                String[] parts = line.split(" ", 2);
                String command = parts[0];
                String inputBody = (parts.length > 1) ? parts[1] : "";

                switch (command) {
                case "todo":
                    handleTodo(inputBody);
                    break;
                case "deadline":
                    handleDeadline(inputBody);
                    break;
                case "event":
                    handleEvent(inputBody);
                    break;
                case "list":
                    handleList();
                    break;
                case "mark":
                    handleMark(inputBody);
                    break;
                case "unmark":
                    handleUnmark(inputBody);
                    break;
                default:
                    throw new BetaException("Hmmmmm? I don't know what this means: " + command);
                }
            } catch (BetaException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
        exitProgram();
    }

    private static void exitProgram() {
        System.out.println("Bye. See you soon!");
    }

    private static void handleUnmark(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("There is nothing to unmark! Please specify which task to unmark.");
        }
        int index = Integer.parseInt(inputBody) - 1;
        if (index >= 0 && index < taskCount) {
            tasks[index].unmarkAsDone();
            System.out.println("Ok I've unmarked this task:");
            System.out.println(tasks[index].toString() + "\n");
        } else {
            throw new BetaException("Invalid task number for unmark.");
        }
    }

    private static void handleMark(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("There is nothing to mark! Please specify which task to mark.");
        }
        int index = Integer.parseInt(inputBody) - 1;
        if (index >= 0 && index < taskCount) {
            tasks[index].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks[index] + "\n");
        } else {
            throw new BetaException("Invalid task number.\n");
        }
    }

    private static void handleList() {
        if (taskCount == 0) {
            System.out.println("YAY!! Good Job!! There is nothing to do.");
        }
        for (int i = 1; i <= taskCount; i++) {
            System.out.println(i + ". " + tasks[i - 1].toString());
        }
        System.out.println("");
    }

    private static void handleEvent(String inputBody) {
        int fromIndex = inputBody.indexOf(" /from ");
        int toIndex = inputBody.indexOf(" /to ");
        String eventTask = inputBody.substring(0, fromIndex);
        String from = inputBody.substring(fromIndex + 7, toIndex);
        String to = inputBody.substring(toIndex + 5);
        tasks[taskCount] = new Event(eventTask, from, to);
        System.out.println("Nice added this: \n" + tasks[taskCount].toString() + "\n");
        taskCount++;
    }

    private static void handleDeadline(String inputBody) {
        int byIndex = inputBody.indexOf(" /by ");
        String deadlineTask = inputBody.substring(0, byIndex);
        String deadline = inputBody.substring(byIndex + 5);
        tasks[taskCount] = new Deadline(deadlineTask, deadline);
        System.out.println("Nice added this: \n" + tasks[taskCount].toString() + "\n");
        taskCount++;
    }

    private static void handleTodo(String inputBody) {
        tasks[taskCount] = new Todo(inputBody);
        System.out.println("Nice added this: \n" + tasks[taskCount].toString() + "\n");
        taskCount++;
    }

    private static void greetUser() {
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
    }
}
