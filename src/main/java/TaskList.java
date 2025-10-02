import java.util.ArrayList;

/**
 * The TaskList class manages a list of tasks.
 * It provides methods for adding, deleting, marking, unmarking, and finding tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Initializes a new, empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Initializes a TaskList with a pre-existing list of tasks.
     *
     * @param tasks The ArrayList of tasks to initialize the list with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the internal ArrayList of tasks.
     *
     * @return The ArrayList of Task objects.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new task to the end of the list.
     *
     * @param task The Task object to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list at the specified index.
     *
     * @param index The 1-based index of the task to delete.
     * @return The Task object that was deleted.
     * @throws BetaException If the index is out of the valid range.
     */
    public Task deleteTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for delete.");
        }
        return tasks.remove(index - 1);
    }

    /**
     * Marks a task as done at the specified index.
     *
     * @param index The 1-based index of the task to mark.
     * @throws BetaException If the index is out of the valid range.
     */
    public void markTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for marking.");
        }
        tasks.get(index - 1).markAsDone();
    }

    /**
     * Unmarks a task as not done at the specified index.
     *
     * @param index The 1-based index of the task to unmark.
     * @throws BetaException If the index is out of the valid range.
     */
    public void unmarkTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for unmarking.");
        }
        tasks.get(index - 1).unmarkAsDone();
    }

    /**
     * Finds tasks in the list whose descriptions contain the specified keyword.
     *
     * @param keyword The keyword to search for.
     * @return A new TaskList containing only the matching tasks.
     */
    public TaskList findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        String lowerCaseKeyword = keyword.toLowerCase();

        for (Task task : tasks) {
            if (task.description.toLowerCase().contains(lowerCaseKeyword)) {
                matchingTasks.add(task);
            }
        }
        return new TaskList(matchingTasks);
    }

    /**
     * Prints all tasks in the list to the user via the Ui.
     * If the list is empty, a celebratory message is shown instead.
     *
     * @param ui The Ui object used for displaying messages.
     */
    public void printTasks(Ui ui) {
        if (tasks.isEmpty()) {
            ui.showMessage("YAY!! Good Job!! There is nothing to do.");
            return;
        }
        StringBuilder response = new StringBuilder("Your tasks are:\n");
        for (int i = 0; i < tasks.size(); i++) {
            response.append(String.format("%d. %s\n", i + 1, tasks.get(i)));
        }
        ui.showMessage(response.toString());
    }

    /**
     * Retrieves a task from the list at the specified index.
     *
     * @param index The 0-based index of the task to retrieve.
     * @return The Task object at the given index.
     */
    public Task get(int index) {
        return tasks.get(index);
    }
}