package duke.exceptions;

/**
 * Define exceptions thrown by {@link duke.userinterface.ConsoleInputParser#}.
 */
@SuppressWarnings("unused")
public class ConsoleInputParserException {
    /**
     * Thrown when command is not found.
     */
    public static class CommandNotFoundException extends DukeException {
        public CommandNotFoundException() {
        }

        public CommandNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command list is not valid.
     */
    public static class InvalidCommandListException extends DukeException {
        public InvalidCommandListException() {
        }

        public InvalidCommandListException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command mark is not valid.
     */
    public static class InvalidCommandMarkException extends DukeException {
        public InvalidCommandMarkException() {
        }

        public InvalidCommandMarkException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command unmark is not valid.
     */
    public static class InvalidCommandUnmarkException extends DukeException {
        public InvalidCommandUnmarkException() {
        }

        public InvalidCommandUnmarkException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command todo is not valid.
     */
    public static class InvalidCommandTodoException extends DukeException {
        public InvalidCommandTodoException() {
        }

        public InvalidCommandTodoException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command deadline is not valid.
     */
    public static class InvalidCommandDeadlineException extends DukeException {
        public InvalidCommandDeadlineException() {
        }

        public InvalidCommandDeadlineException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command event is not valid.
     */
    public static class InvalidCommandEventException extends DukeException {
        public InvalidCommandEventException() {
        }

        public InvalidCommandEventException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command delete is not valid.
     */
    public static class InvalidCommandDeleteException extends DukeException {
        public InvalidCommandDeleteException() {
        }

        public InvalidCommandDeleteException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when command find is not valid.
     */
    public static class InvalidCommandFindException extends DukeException {
        public InvalidCommandFindException() {

        }

        public InvalidCommandFindException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when forbidden characters are found in command todo.
     */
    public static class ForbiddenCharactersCommandTodoException extends DukeException {
        public ForbiddenCharactersCommandTodoException() {

        }

        public ForbiddenCharactersCommandTodoException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when forbidden characters are found in command deadline.
     */
    public static class ForbiddenCharactersCommandDeadlineException extends DukeException {
        public ForbiddenCharactersCommandDeadlineException() {

        }

        public ForbiddenCharactersCommandDeadlineException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when forbidden characters are found in command event.
     */
    public static class ForbiddenCharactersCommandEventException extends DukeException {
        public ForbiddenCharactersCommandEventException() {

        }

        public ForbiddenCharactersCommandEventException(String message) {
            super(message);
        }
    }
}
