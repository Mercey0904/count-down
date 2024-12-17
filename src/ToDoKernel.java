import components.standard.Standard;

/**
 * Kernel interface for the ToDoList data type.
 */
public interface ToDoKernel extends Standard {

    /**
     * Marks the completion of a task by removing the task.
     *
     * @param task
     *            The task to be marked as completed.
     * @return true if the task completion was successful, false otherwise.
     * @requires task != null
     * @ensures the task is removed from the list of tasks
     */
    boolean completeTask(String task);

    /**
     * Allows users to schedule tasks in advance, specifying start times and
     * expected durations.
     *
     * @param task
     *            The task to be scheduled.
     * @param dateline
     *            The completion date.
     * @requires task != null && dateline != null
     * @requires date in correct format
     * @ensures the task is scheduled with the specified completion date
     */
    void scheduleTask(String task, String dateline);

    /**
     * Sets the method used for checking dates.
     *
     * @param dateCheckMethod
     *            The method used for checking dates.
     */
    void setDateCheck(String date);

}
