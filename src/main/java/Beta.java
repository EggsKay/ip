import java.util.Scanner;

public class Beta {
    public static void main(String[] args) {
        String line = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! I'm Beta\n" + "What can I do for you?\n");
        while (!line.equals("bye")) {
            line = in.nextLine();
            System.out.println(line +"\n");
        }
        System.out.println("Bye. See you soon!");
    }
}
