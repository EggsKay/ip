/**
 * Represents a deadline task. A deadline has a description and a due date/time.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Initializes a new Deadline object with the given description and due date/time.
     * The task is initially marked as not done.
     *
     * @param description The description of the deadline task.
     * @param by The due date/time of the deadline.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string representation of the Deadline task.
     * The format includes the task type prefix `[D]`, description, and the due date/time.
     *
     * @return A string representing the Deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Encodes the Deadline task into a format suitable for saving to a file.
     * The format is `D | isDone | description | by`.
     *
     * @return A string representing the encoded Deadline task.
     */
    @Override
    public String encode() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}