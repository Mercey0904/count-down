import components.map.Map;

/**
 * Enhanced interface for the ToDoList data type.
 *
 *
 * @extends ToDoListKernel<T>
 */
public interface ToDo extends ToDoKernel {

    /**
     * Identifies and retrieves a list of tasks that are overdue, prompting
     * users to address pending responsibilities.
     *
     * @return A list of overdue tasks.
     * @ensures <pre>
     * {@code a list of overdue tasks is returned}
     * </pre>
     */
    Map<String, String> getOverdueTasks();

    /**
     * Allows users to view a detailed overview of their schedule for a specific
     * date.
     *
     * @param date
     *            The date for which the daily schedule is requested.
     * @return A list of tasks scheduled for the specified date.
     * @requires <pre>
     * {@code date is not null}
     * </pre>
     * @ensures <pre>
     * {@code a list of tasks scheduled for the specified date is returned}
     * </pre>
     */
    Map<String, String> dailySchedule(String date);

}
