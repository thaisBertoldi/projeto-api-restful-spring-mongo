package workshopmongo.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import workshopmongo.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
        HttpStatus statusError = HttpStatus.NOT_FOUND;
        StandartError errorBody = new StandartError(
            System.currentTimeMillis(),
            statusError.value(),
            "Não encontrado",
            exception.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(statusError).body(errorBody);
    }
}
