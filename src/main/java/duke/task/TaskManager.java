package duke.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public TaskManager(String path) {
        loadTasks(path);
    }

    /**
     * Prints all tasks in list to standard out.
     */
    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            int taskNumber = i + 1;
            System.out.print(taskNumber + ".");

            Task task = tasks.get(i);
            task.print();
        }
    }

    /**
     * Returns number of tasks in task manager.
     *
     * @return Number of tasks
     */
    public int getNumTasks() {
        return tasks.size();
    }

    /**
     * Adds a task to list of tasks.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);

        saveTasks();
    }

    /**
     * Gets a task from list of tasks
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @return Task
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager
     */
    public Task getTask(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            return task;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Deletes a task from list of tasks
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @return Task
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager
     */
    public Task deleteTask(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            tasks.remove(taskIndex);

            saveTasks();

            return task;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Marks a task as completed.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager
     */
    public void markTaskAsCompleted(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            task.setComplete(true);

            saveTasks();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Marks a task as uncompleted.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager
     */
    public void markTaskAsUncompleted(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            task.setComplete(false);

            saveTasks();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    public void saveTasks() {
        Path tasksDirectoryPath = Paths.get("./data/");
        Path tasksFilePath = Paths.get("./data/tasks.txt");

        if (Files.notExists(tasksDirectoryPath)) {
            try {
                Files.createDirectories(tasksDirectoryPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String tasksStr = "";
        for (Task task : tasks) {
            tasksStr += Task.convertToString(task);
            tasksStr += "\n";
        }

        try {
            Files.writeString(tasksFilePath, tasksStr, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadTasks(String path) {
        tasks = new ArrayList<>();

        Path tasksFilePath = Paths.get(path);

        String tasksStr;
        try {
            tasksStr = Files.readString(tasksFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] tasksStrArr = tasksStr.split("\n");
        for (String taskStr : tasksStrArr) {
            Task task = Task.convertFromString(taskStr);
            tasks.add(task);
        }
    }
}
