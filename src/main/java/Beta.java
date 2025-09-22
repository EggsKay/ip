import java.util.ArrayList;
import java.util.Scanner;

public class Beta {

    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Storage storage = new Storage("./data/beta.txt");

    public static void main(String[] args) {
        storage.load(tasks);
        Scanner in = new Scanner(System.in);
        greetUser();

        while (true) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) break;

            try {
                String[] parts = line.split(" ", 2);
                String command = parts[0].toLowerCase();
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
                case "delete":
                    handleDelete(inputBody);
                    break;
                default:
                    throw new BetaException("Hmmmmm? I don't know what this means: " + command);
                }
            } catch (BetaException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

        storage.save(tasks);
        exitProgram();
    }

    private static void greetUser() {
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
    }

    private static void exitProgram() {
        System.out.println("Bye. See you soon!");
    }

    private static void handleTodo(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("Your task is empty. Please input a valid task.");
        }
        Task task = new Todo(inputBody.trim());
        tasks.add(task);
        System.out.println("Nice added this: \n" + task + "\n");
        storage.save(tasks);
    }

    private static void handleDeadline(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("It's empty. Reminder to put the description of your deadline.");
        }
        if (!inputBody.contains(" /by ")) {
            throw new BetaException("Deadline format must be: deadline <description> /by <time>");
        }
        int byIndex = inputBody.indexOf(" /by ");
        String deadlineTask = inputBody.substring(0, byIndex);
        String deadline = inputBody.substring(byIndex + 5);

        if (deadline.isEmpty()) {
            throw new BetaException("When do you want to do this task by?");
        }

        Task task = new Deadline(deadlineTask, deadline);
        tasks.add(task);
        System.out.println("Nice added this: \n" + task + "\n");
        storage.save(tasks);
    }

    private static void handleEvent(String inputBody) throws BetaException {
        if (!inputBody.contains(" /from ") || !inputBody.contains(" /to ")) {
            throw new BetaException("Event format must be: event <description> /from <start> /to <end>");
        }

        int fromIndex = inputBody.indexOf(" /from ");
        int toIndex = inputBody.indexOf(" /to ");
        String eventTask = inputBody.substring(0, fromIndex);
        String from = inputBody.substring(fromIndex + 7, toIndex);
        String to = inputBody.substring(toIndex + 5);

        Task task = new Event(eventTask, from, to);
        tasks.add(task);
        System.out.println("Nice added this: \n" + task + "\n");
        storage.save(tasks);
    }

    private static void handleList() {
        if (tasks.isEmpty()) {
            System.out.println("YAY!! Good Job!! There is nothing to do.\n");
            return;
        }
        System.out.println("Your tasks are:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("");
    }

    private static void handleMark(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("There is nothing to mark! Please specify which task to mark.");
        }
        int index = Integer.parseInt(inputBody) - 1;
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(task + "\n");
            storage.save(tasks);
        } else {
            throw new BetaException("Invalid task number.");
        }
    }

    private static void handleUnmark(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("There is nothing to unmark! Please specify which task to unmark.");
        }
        int index = Integer.parseInt(inputBody) - 1;
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.unmarkAsDone();
            System.out.println("Ok I've unmarked this task:");
            System.out.println(task + "\n");
            storage.save(tasks);
        } else {
            throw new BetaException("Invalid task number for unmark.");
        }
    }

    private static void handleDelete(String inputBody) throws BetaException {
        if (inputBody == null || inputBody.trim().isEmpty()) {
            throw new BetaException("Give me something to delete! Please specify which task to delete.");
        }
        int index;
        try {
            index = Integer.parseInt(inputBody.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new BetaException("Invalid delete command! Provide a valid task number.");
        }
        if (index < 0 || index >= tasks.size()) {
            throw new BetaException("Invalid task number for delete.");
        }

        Task removedTask = tasks.remove(index);
        System.out.println("Alright. I've removed this task:");
        System.out.println(removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.\n");
        storage.save(tasks);
    }
}
