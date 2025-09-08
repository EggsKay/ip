import java.util.Scanner;
import java.util.Arrays;

public class Beta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
        Task[] list = new Task[100];
        int listSize = 0;

        while (true) {
            String line = in.nextLine();
            if (line.equals("bye")) break;

            String[] parts = line.split(" ", 2);
            String command = parts[0];
            String inputBody = (parts.length > 1) ? parts[1] : "";

            switch (command) {

            case "todo":
                list[listSize] = new Todo(inputBody);
                System.out.println("Nice added this: \n" + list[listSize].toString() + "\n");
                listSize++;
                break;

            case "deadline":
                int byIndex = inputBody.indexOf(" /by ");
                String deadlineTask = inputBody.substring(0, byIndex);
                String deadline = inputBody.substring(byIndex + 5);
                list[listSize] = new Deadline(deadlineTask, deadline);
                System.out.println("Nice added this: \n" + list[listSize].toString() + "\n");
                listSize++;
                break;

            case "event":
                int fromIndex = inputBody.indexOf(" /from ");
                int toIndex = inputBody.indexOf(" /to ");
                String eventTask = inputBody.substring(0, fromIndex);
                String from = inputBody.substring(fromIndex + 7, toIndex);
                String to = inputBody.substring(toIndex + 5);
                list[listSize] = new Event(eventTask, from, to);
                System.out.println("Nice added this: \n" + list[listSize].toString() + "\n");
                listSize++;
                break;

            case "list":
                if (listSize == 0) {
                    System.out.println("YAY!! Good Job!! There is nothing to do.");
                }
                for (int i = 1; i <= listSize; i++) {
                    System.out.println(i + ". " + list[i - 1].toString());
                }
                System.out.println("");
                break;
            case "mark": {
                int index = Integer.parseInt(inputBody) - 1;
                if (index >= 0 && index < listSize) {
                    list[index].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(list[index] + "\n");
                } else {
                    System.out.println("Invalid task number.\n");
                }
            }
            break;
            case "unmark": {
                int index = Integer.parseInt(inputBody) - 1;
                if (index >= 0 && index < listSize) {
                    list[index].unmarkAsDone();
                    System.out.println("Ok I've unmarked this task:");
                    System.out.println(list[index].toString() + "\n");
                } else {
                    System.out.println("Invalid task number.\n");
                }
                break;
            }
            }
        }
        System.out.println("Bye. See you soon!");
    }
}
