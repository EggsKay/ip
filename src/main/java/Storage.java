import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Storage class handles reading from and writing to the hard disk.
 * It is responsible for saving the task list to a file and loading tasks from it.
 */
public class Storage {
    private final String filePath;
    /**
     * Initializes a new Storage object with the specified file path.
     *
     * @param filePath The path to the file where tasks are saved.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the list of tasks to the file at the configured file path.
     * Each task is converted into a string format before being written to the file.
     *
     * @param tasks The ArrayList of Task objects to be saved.
     * @throws BetaException If there is an error writing to the file.
     */
    public void save(ArrayList<Task> tasks) throws BetaException {
        try {
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileWriter writer = new FileWriter(file);
            for (Task task : tasks) {
                writer.write(task.encode() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new BetaException("Failed to save tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the file at the configured file path.
     * If the file does not exist, an empty list is returned.
     *
     * @return An ArrayList of Task objects loaded from the file.
     * @throws BetaException If there is an error reading the file or decoding a task.
     */
    public ArrayList<Task> load() throws BetaException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }
        try {

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = TaskDecoder.decode(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
            return tasks;
        } catch (IOException e) {

            throw new BetaException("");
        }
    }
}


