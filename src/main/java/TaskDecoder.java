/**
 * The TaskDecoder class is responsible for converting a string representation of a task
 * (typically from a saved file) back into a Task object.
 */
public class TaskDecoder {
    /**
     * Decodes a single line from the saved task file into a Task object.
     * The line is expected to be in a specific format (e.g., "T | 1 | read book").
     *
     * @param line The string line to be decoded.
     * @return The corresponding Task object (Todo, Deadline, or Event).
     */
    public static Task decode(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        Task task = null;

        switch (type) {
        case "T":
            task = new Todo(parts[2]);
            break;
        case "D":
            task = new Deadline(parts[2], parts[3]);
            break;
        case "E":
            task = new Event(parts[2], parts[3], parts[4]);
            break;
        }

        if (isDone && task != null) {
            task.markAsDone();
        }
        return task;
    }
}