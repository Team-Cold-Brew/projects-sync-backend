package projectSync.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // Esta anotación hace que la clase actúe como un interceptor global de excepciones.
public class GlobalExceptionHandler {

    // Este método se ejecutará CADA VEZ que se lance una ResourceNotFoundException
    // desde CUALQUIER controlador.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        // Creamos un cuerpo de error personalizado y limpio
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        // Usamos ResponseEntity para tener control total sobre la respuesta HTTP
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Puedes añadir más métodos @ExceptionHandler para otros tipos de excepciones
    @ExceptionHandler(Exception.class) // Un manejador genérico para cualquier otra excepción
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "An unexpected error occurred. Contact the administrator.");
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
