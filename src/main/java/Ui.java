import java.util.Scanner;

/**
 * The Ui class handles all interactions with the user,
 * including reading commands and displaying messages.
 */
public class Ui {
    private final Scanner in;

    /**
     * Initializes a new Ui object to handle user input.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Displays a greeting message to the user upon starting the application.
     */
    public void greetUser() {
        System.out.println("Hello! I'm Beta\nWhat can I do for you?\n");
    }

    /**
     * Reads a command line from the user.
     *
     * @return The full command line input as a String.
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Displays a general message to the user.
     *
     * @param message The message string to be displayed.
     */
    public void showMessage(String message) {
        System.out.println(message + "\n");
    }

    /**
     * Displays an error message to the user.
     *
     * @param errorMessage The error message string to be displayed.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage + "\n");
    }

    /**
     * Displays a specific error message when the data file cannot be found.
     */
    public void showLoadingError() {
        System.out.println("No file found to load.\n");
    }

    /**
     * Displays a farewell message to the user before exiting the application.
     */
    public void showExitMessage() {
        System.out.println("Bye. See you soon!\n");
    }
}
