package duke.commands;

/**
 * Stores arguments for find command.
 */
@SuppressWarnings("ALL")
public class ConsoleCommandFind extends ConsoleCommand {
    private String description;

    /**
     * Initializes object with arguments for find command.
     *
     * @param description Description of the task to find.
     */
    public ConsoleCommandFind(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
