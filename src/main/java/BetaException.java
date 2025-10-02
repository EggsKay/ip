/**
 * Represents a custom exception specific to the Beta application.
 * This exception is used to handle and throw application-specific errors.
 */
public class BetaException extends Exception {

    /**
     * Initializes a new BetaException with a specified error message.
     *
     * @param message The error message for the exception.
     */
    public BetaException(String message) {
        super(message);
    }
}

