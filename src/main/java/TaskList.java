import java.util.ArrayList;


public class TaskList {
    private final ArrayList<Task> tasks;


    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public int size() {
        return tasks.size();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }


    public void addTask(Task task) {
        tasks.add(task);
    }


    public Task deleteTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for delete.");
        }
        return tasks.remove(index - 1);
    }


    public void markTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for marking.");
        }
        tasks.get(index - 1).markAsDone();
    }


    public void unmarkTask(int index) throws BetaException {
        if (index <= 0 || index > tasks.size()) {
            throw new BetaException("Invalid task number for unmarking.");
        }
        tasks.get(index - 1).unmarkAsDone();
    }

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


    public Task get(int index) {
        return tasks.get(index);
    }
}