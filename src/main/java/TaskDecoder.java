public class TaskDecoder {
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