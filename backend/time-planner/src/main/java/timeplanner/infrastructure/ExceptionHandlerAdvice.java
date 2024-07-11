package timeplanner.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest exception handler
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({HttpMessageNotReadableException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingRequestHeaderException.class})
    public ResponseEntity<Error> handleReadRequestException(Exception exception) {
        return new ResponseEntity<>(new Error("Error during reading request"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception) {
        return new ResponseEntity<>(new Error("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleException(EntityNotFoundException exception) {
        return new ResponseEntity<>(new Error("Item not found"), HttpStatus.NOT_FOUND);
    }

    @Data
    private static class Error {
        private final String message;

        public Error(String message) {
            this.message = message;
        }
    }
}
