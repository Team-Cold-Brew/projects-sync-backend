package projectSync.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.time.Instant;

/**
 * Global exception handler for the REST API.
 * This class uses {@link RestControllerAdvice} to intercept exceptions thrown by controllers
 * and translate them into a standardized, client-friendly {@link ProblemDetail} JSON response,
 * following the RFC 7807 standard.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // It's a good practice to have a logger available for the generic handler.
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles {@link ResourceNotFoundException} instances.
     * This method is triggered when a requested resource does not exist. It creates a
     * standard {@link ProblemDetail} response with an HTTP 404 (Not Found) status.
     *
     * @param ex The caught {@link ResourceNotFoundException}.
     * @return A {@link ProblemDetail} object that will be serialized into the HTTP response body.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Resource Not Found");
        problemDetail.setType(URI.create("")); // URL
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    /**
     * A catch-all handler for any unhandled {@link Exception}.
     * This method prevents sensitive information (like stack traces) from leaking to the client.
     * It returns a generic {@link ProblemDetail} response with an HTTP 500 (Internal Server Error) status.
     * The actual exception should be logged for debugging purposes.
     *
     * @param ex The caught {@link Exception}.
     * @return A generic {@link ProblemDetail} object for internal server errors.
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericException(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected internal error has occurred.");
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setType(URI.create("")); // URL
        problemDetail.setProperty("timestamp", Instant.now());

        log.error("An unexpected error occurred: {}", ex.getMessage(), ex);

        return problemDetail;
    }
}
