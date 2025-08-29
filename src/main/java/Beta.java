import java.util.Scanner;
import java.util.Arrays;

public class Beta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
        Task[] list = new Task[100];
        int listSize = 0;

        String line = "";
        while (!(line = in.nextLine()).equals("bye")) {

            if (line.startsWith("mark ")) {
                int index = Integer.parseInt(line.split(" ")[1]) - 1;
                if (index >= 0 && index < listSize) {
                    list[index].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [" + list[index].getStatusIcon() + "] " + list[index].getDescription() + "\n");
                } else {
                    System.out.println("Invalid task number.\n");
                }
                continue;
            }

            if (line.startsWith("unmark ")) {
                int index = Integer.parseInt(line.split(" ")[1]) - 1;
                if (index >= 0 && index < listSize) {
                    list[index].unmarkAsDone();
                    System.out.println("Ok I've unmarked this task:");
                    System.out.println("  [" + list[index].getStatusIcon() + "] " + list[index].getDescription() + "\n");
                } else  {
                    System.out.println("Invalid task number.\n");
                }
                continue;
            }

            switch (line) {
            case "list":
                for (int i = 1; i <= listSize; i++) {
                    System.out.println(i + ". " + "[" + list[i-1].getStatusIcon() + "]" + list[i - 1].getDescription());
                }
                System.out.println("");
                break;

            default:
                System.out.println("Added: " + line + "\n");
                list[listSize] = new Task(line);
                listSize++;
                break;
            }
        }
        System.out.println("Bye. See you soon!");
    }
}
