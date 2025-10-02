/**
 * Represents an event task. An event has a description and a start and end time.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Initializes a new Event object with the given description, start, and end times.
     * The task is initially marked as not done.
     *
     * @param description The description of the event task.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the string representation of the Event task.
     * The format includes the task type prefix `[E]`, description, and the start and end times.
     *
     * @return A string representing the Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + ", to: " + to + ")";
    }

    /**
     * Encodes the Event task into a format suitable for saving to a file.
     * The format is `E | isDone | description | from | to`.
     *
     * @return A string representing the encoded Event task.
     */
    @Override
    public String encode() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
