import java.util.Scanner;


public class Ui {
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }


    public void greetUser() {
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
    }


    public String readCommand() {
        return in.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message + "\n");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }
    public void showLoadingError() {
        System.out.println("No file found to load.\n");
    }
    public void showExitMessage() {
        System.out.println("Bye. See you soon!\n");
    }
}
