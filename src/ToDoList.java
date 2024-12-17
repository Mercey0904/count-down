
import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Lets the user enter task details to create a to-do list
 *
 * @author Jia Hui Tang
 *
 */

public class ToDoList {
    private Map<String, String> tasks;

    /**
     * No argument constructor--private to prevent instantiation.
     */

    // Constructor
    public ToDoList() {
        this.tasks = new Map1L<>();
    }

    // Kernel Methods

    /**
     * Marks the completion of a task and removes it from the list.
     *
     * @param task
     *            The task to be marked as completed.
     * @return true if the task completion was successful, false otherwise.
     */
    public boolean completeTask(String task) {
        // Implementation logic for completing task
        // Remove the task from the map
        return this.tasks.remove(task) != null;
    }

    /**
     * Allows users to schedule tasks in advance, specifying start times and
     * expected durations.
     *
     * @param task
     *            The task to be scheduled.
     * @param deadline
     *            The completion deadline for the task.
     * @throws IllegalArgumentException
     *             if task or deadline is null
     */
    public void scheduleTask(String task, String deadline) {
        if (task == null || deadline == null) {
            throw new IllegalArgumentException(
                    "Task and deadline cannot be null");
        }
        // Add the task and deadline to the map
        this.tasks.add(task, deadline);
    }

    // Secondary Methods

    /**
     * Identifies and retrieves a list of tasks that are overdue, prompting
     * users to address pending responsibilities.
     *
     * @return A map of overdue tasks with their deadlines.
     */
    public Map<String, String> getOverdueTasks() {
        Map<String, String> overdueTasks = new Map1L<>();

        // Logic to check for overdue tasks
        // Replace with your implementation
        for (Map.Pair<String, String> entry : this.tasks) {
            if (entry.key().toLowerCase().contains("deadline")) {
                overdueTasks.add(entry.key(), entry.value());
            }
        }

        return overdueTasks;
    }

    /**
     * Allows users to view a detailed overview of their schedule for a specific
     * date.
     *
     * @param date
     *            The date for which the daily schedule is requested.
     * @return A map of tasks scheduled for the specified date with their
     *         deadlines.
     */
    public Map<String, String> dailySchedule(String date) {
        // Implementation logic for retrieving daily schedule
        return null;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        try (SimpleWriter out = new SimpleWriter1L();
                SimpleReader in = new SimpleReader1L()) {

            ToDoList toDo = new ToDoList();

            // View daily schedule
            Map<String, String> dailySchedule = toDo.dailySchedule("");
            out.println("Daily Schedule for 2024-04-14:");
            for (Map.Pair<String, String> entry : dailySchedule) {
                out.println("- " + entry.key() + " (Scheduled for "
                        + entry.value() + ")");
            }

            // Schedule a task
            toDo.scheduleTask("Write report", "2024-04-15");

            // Get overdue tasks
            Map<String, String> overdueTasks = toDo.getOverdueTasks();
            out.println("Overdue Tasks:");
            for (Map.Pair<String, String> entry : overdueTasks) {
                out.println("- " + entry.key() + " (Deadline: " + entry.value()
                        + ")");
            }

            // Complete a task
            toDo.completeTask("Study for exam");
        }
    }

}
