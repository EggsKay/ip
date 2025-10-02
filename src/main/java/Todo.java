/**
 * Represents a to-do task. A todo task has a description but no time constraints.
 */
public class Todo extends Task {

    /**
     * Initializes a new Todo object with the given description.
     * The task is initially marked as not done.
     *
     * @param description The description of the to-do task.
     */
    public Todo(String description) {
        super(description);
        isDone = false;
    }

    /**
     * Returns the string representation of the Todo task.
     * The format includes the task type prefix `[T]`.
     *
     * @return A string representing the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Encodes the Todo task into a format suitable for saving to a file.
     * The format is `T | isDone | description`.
     *
     * @return A string representing the encoded Todo task.
     */
    @Override
    public String encode() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}