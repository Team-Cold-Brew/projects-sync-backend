package projectSync.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message and cause.
     * This is useful for wrapping lower-level exceptions while preserving the original stack trace.
     *
     * @param message The detail message.
     * @param cause   The cause (which is saved for later retrieval by the getCause() method).
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ResourceNotFoundException with a standardized error message
     * built from the resource type and its identifier. This is a clean and recommended practice
     * for generating consistent error messages.
     * <p>
     * Example Message: "Resource 'Project' with identifier '123' was not found."
     *
     * @param resourceType The {@link Class} of the resource that was not found (e.g., Project.class).
     * @param id           The identifier of the resource that was not found (e.g., a Long or String ID).
     */
    public ResourceNotFoundException(Class<?> resourceType, Object id) {
        super(String.format("Resource '%s' with identifier '%s' was not found.",
                resourceType.getSimpleName(), id));
    }
}
