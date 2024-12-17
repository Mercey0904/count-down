
import java.text.SimpleDateFormat;
import java.util.Date;

import components.map.Map;
import components.map.Map1L;

/**
 * Abstract class for the ToDoList data type.
 *
 * @param <T>
 *            Type of elements in the list
 */
public abstract class ToDoSecondary implements ToDoKernel {

    // Data structure to store tasks and deadlines
    protected Map<String, String> tasks;

    /**
     * Constructor to initialize the task map.
     */

    @Override
    public void scheduleTask(String task, String deadline) {
        // Ensure task and deadline are not null
        if (task == null || deadline == null) {
            throw new IllegalArgumentException(
                    "Task and deadline cannot be null");
        }
        this.tasks.add(task, deadline);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ToDoSecondary) {
            ToDoSecondary other = (ToDoSecondary) obj;
            return this.tasks.equals(other.tasks);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.tasks.hashCode();
    }

    @Override
    public String toString() {
        return this.tasks.toString();
    }

    /**
     * Identifies and retrieves a map of tasks that are overdue, prompting users
     * to address pending responsibilities.
     *
     * @return A map of overdue tasks with their corresponding deadlines.
     */
    public Map<String, String> getOverdueTasks() {
        Map<String, String> overdueTasks = new Map1L<>();
        for (Map.Pair<String, String> entry : this.tasks) {
            if (this.isOverdue(entry.value())) {
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
        Map<String, String> schedule = new Map1L<>();
        for (Map.Pair<String, String> entry : this.tasks) {
            if (entry.value().equals(date)) {
                schedule.add(entry.key(), entry.value());
            }
        }
        return schedule;
    }

    /**
     * Checks if the given deadline is overdue.
     *
     * @param deadline
     *            The deadline to check.
     * @return True if the deadline is overdue, false otherwise.
     */
    protected boolean isOverdue(String deadline) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYY");
        Date date2 = new Date();
        String dFormat = dateFormat.format(date2);

        int tMonth = Integer.parseInt(dFormat.substring(0, 2));
        int tDay = Integer.parseInt(dFormat.substring(2, 4));
        int tYear = Integer.parseInt(dFormat.substring(4, 6));

        int day = Integer.parseInt(deadline.substring(0, 2));
        int month = Integer.parseInt(deadline.substring(2, 4));
        int year = Integer.parseInt(deadline.substring(4, 6));

        if (year == tYear) {
            if (month >= tMonth & month <= 12) {
                switch (month) {
                    case 4:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 6:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 9:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 11:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 1:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 3:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 5:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 7:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 8:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 10:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 12:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 2:
                        if (year % 4 == 0 && day > 29) {
                            return false;
                        }
                    default:
                        return false;
                }
            } else if (month == tMonth & day >= tDay) {
                switch (month) {
                    case 4:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 6:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 9:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 11:
                        if (day > 30) {
                            return false;
                        }
                        break;
                    case 1:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 3:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 5:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 7:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 8:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 10:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 12:
                        if (day > 31) {
                            return false;
                        }
                        break;
                    case 2:
                        if (year % 4 == 0 && day > 29) {
                            return false;
                        }
                    default:
                        return false;
                }
            } else {
                return false;
            }

        } else if (year > tYear) {
            if (day < 1 || day > 31) {
                return false;
            }
            switch (month) {
                case 4:
                    if (day > 30) {
                        return false;
                    }
                    break;
                case 6:
                    if (day > 30) {
                        return false;
                    }
                    break;
                case 9:
                    if (day > 30) {
                        return false;
                    }
                    break;
                case 11:
                    if (day > 30) {
                        return false;
                    }
                    break;
                case 1:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 3:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 5:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 7:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 8:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 10:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 12:
                    if (day > 31) {
                        return false;
                    }
                    break;
                case 2:
                    if (year % 4 == 0 && day > 29) {
                        return false;
                    }
                    if (day > 28) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            if (year < tYear) {
                return false;
            }
        }
        return true;
    }

    // Implementation logic to determine if a deadline is overdue
    // For demonstration, let's assume the deadline is overdue if it's before the current date
    // You can replace this with your own implementation
    // For now, we'll return true for any non-null deadline

}
