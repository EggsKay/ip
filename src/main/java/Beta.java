import java.util.Scanner;
import java.util.Arrays;

public class Beta {
    public static void main(String[] args) {
        String line = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I'm Beta\n" + "What can I do for you?\n");
        String[] list = new String[100];
        int listSize = 0;
        while (!(line = in.nextLine()).equals("bye")) {
            switch (line) {

            case "list":
                for (int i = 1; i <= listSize; i++) {
                    System.out.println(i + ". " + list[i - 1]);
                }
                System.out.println("");
                break;
            case "bye":

                break;
            default:
                System.out.println("Added: " + line + "\n");
                list[listSize] = line;
                listSize++;
                break;
            }
        }
        System.out.println("Bye. See you soon!");
    }
}
