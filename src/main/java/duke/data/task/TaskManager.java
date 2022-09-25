package duke.data.task;

import duke.exceptions.TaskManagerException;
import duke.storage.LocalStorage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Stores tasks and manages task-list.
 */
@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class TaskManager {
    public final String DEFAULT_TASKS_PATH = "./data/";
    public final String DEFAULT_TASKS_FILENAME = "tasks.txt";

    private ArrayList<Task> tasks;
    private String tasksPath;
    private String tasksFilename;

    /**
     * Initializes task manager with empty task-list and default values.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.tasksPath = DEFAULT_TASKS_PATH;
        this.tasksFilename = DEFAULT_TASKS_FILENAME;
    }

    /**
     * Initializes task manager by loading stored tasks.
     *
     * @param tasksPath Path of the directory to load.
     * @param tasksFilename Filename of the tasks file.
     */
    public TaskManager(String tasksPath, String tasksFilename) {
        this.tasksPath = tasksPath;
        this.tasksFilename = tasksFilename;
        loadTasks();
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
     * @return Number of tasks.
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
    }

    /**
     * Gets a task from list of tasks.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @return Task.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager.
     */
    public Task getTask(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            return tasks.get(taskIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Gets task number for task in list of tasks.
     *
     * @param task Task.
     * @return Task number.
     */
    public int getTaskNumber(Task task) {
        return tasks.indexOf(task) + 1;
    }

    /**
     * Deletes a task from list of tasks.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @return Task.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager.
     */
    public Task deleteTask(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            tasks.remove(taskIndex);

            return task;
        } catch (IndexOutOfBoundsException e) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Find tasks in list of tasks that matches description.
     *
     * @param description Description of the task.
     * @return List of tasks that matches the description.
     */
    public ArrayList<Task> findTask(String description) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.description.contains(description)) {
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
    }

    /**
     * Marks a task as completed.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager.
     */
    public void markTaskAsCompleted(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            task.setComplete(true);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Marks a task as uncompleted.
     *
     * @param taskNumber Task number of task as shown by the function {@link #printTasks()}.
     * @throws TaskManagerException.TaskNotFoundException If task is not the task manager.
     */
    public void markTaskAsUncompleted(int taskNumber) throws TaskManagerException.TaskNotFoundException {
        int taskIndex = taskNumber - 1;
        try {
            Task task = tasks.get(taskIndex);
            task.setComplete(false);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskManagerException.TaskNotFoundException();
        }
    }

    /**
     * Save tasks in task-list.
     *
     * @throws TaskManagerException.TasksFileIOException If there was an error saving the tasks.
     */
    public void saveTasks() throws TaskManagerException.TasksFileIOException {
        try {
            LocalStorage.saveTasks(tasks, tasksPath, tasksFilename);
        } catch (IOException e) {
            throw new TaskManagerException.TasksFileIOException("The tasks could not be saved to disk.");
        }
    }

    /**
     * Load tasks into task-list.
     */
    public void loadTasks() {
        try {
            tasks = LocalStorage.loadTasks(tasksPath, tasksFilename);
        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }
}