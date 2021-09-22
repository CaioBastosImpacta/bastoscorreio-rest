package br.com.app.bastoscorreios.adapters.exception;

import br.com.app.bastoscorreios.application.exception.BadBusyException;
import br.com.app.bastoscorreios.application.exception.NoContentDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerAdvicerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadBusyException.class)
    public final ResponseEntity<?> handlerBadBusyException(Exception exception) {
        int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();

        MessageExceptionModelResponse messageExceptionModelResponse =
                createMessageException(httpStatus, exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageExceptionModelResponse);
    }

    @ExceptionHandler(NoContentDataException.class)
    public final ResponseEntity<?> handlerNoContentData(Exception exception) {
        int httpStatus = HttpStatus.NO_CONTENT.value();

        MessageExceptionModelResponse messageExceptionModelResponse =
                createMessageException(httpStatus, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messageExceptionModelResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<?> handlerBadRequest(Exception exception) {
        int httpStatus = HttpStatus.BAD_REQUEST.value();

        MessageExceptionModelResponse messageExceptionModelResponse =
                createMessageException(httpStatus, exception.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageExceptionModelResponse);
    }

    private MessageExceptionModelResponse createMessageException(int httpStatus, String message) {
        return new MessageExceptionModelResponse(httpStatus, message);
    }
}
