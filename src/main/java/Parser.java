public class Parser {


    public static String[] parse(String fullCommand) throws BetaException {
        if (fullCommand == null || fullCommand.trim().isEmpty()) {

            throw new BetaException("Your command is empty. Please enter a command.");
        }


        String[] parts = fullCommand.trim().split(" ", 2);
        String command = parts[0].toLowerCase();
        String inputBody = (parts.length > 1) ? parts[1].trim() : "";


        switch (command) {
        case "mark":
        case "unmark":
        case "delete":

            if (inputBody.isEmpty()) {
                throw new BetaException("The task number for '" + command + "' command cannot be empty.");
            }
            try {
                Integer.parseInt(inputBody);
            } catch (NumberFormatException e) {
                throw new BetaException("The task number for '" + command + "' must be a valid integer.");
            }
            break;
        case "todo":

            if (inputBody.isEmpty()) {
                throw new BetaException("The description for a 'todo' command cannot be empty.");
            }
            break;
        case "deadline":

            if (!inputBody.contains(" /by ")) {
                throw new BetaException("Deadline format must be: deadline <description> /by <time>");
            }
            break;
        case "event":

            if (!inputBody.contains(" /from ") || !inputBody.contains(" /to ")) {
                throw new BetaException("Event format must be: event <description> /from <start> /to <end>");
            }
            break;
        case "find":
            
            if (inputBody.isEmpty()) {
                throw new BetaException("The 'find' command requires a keyword to search for.");
            }
            break;
        case "list":
        case "bye":

            break;
        }

        return new String[]{command, inputBody};
    }
}

