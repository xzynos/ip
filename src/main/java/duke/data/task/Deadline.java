package duke.data.task;

import java.time.LocalDateTime;

/**
 * Stores deadlines.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Initializes deadline object.
     *
     * @param description Description of the deadline.
     * @param by Due date and time of the deadline.
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    public LocalDateTime getBy() {
        return by;
    }

    public void setBy(LocalDateTime by) {
        this.by = by;
    }
}
