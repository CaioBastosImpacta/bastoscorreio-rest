package br.com.app.bastoscorreios.adapters.exception;

import br.com.app.bastoscorreios.application.exception.BadBusyException;
import br.com.app.bastoscorreios.application.exception.NoContentDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerAdvicerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadBusyException.class)
    public final ResponseEntity<?> handlerBadBusyException(Exception exception, WebRequest webRequest) {
        int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();

        MessageExceptionModelResponse messageExceptionModelResponse =
                new MessageExceptionModelResponse(httpStatus, exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(messageExceptionModelResponse);
    }

    @ExceptionHandler(NoContentDataException.class)
    public final ResponseEntity<?> handlerNoContentData(Exception exception, WebRequest webRequest) {
        int httpStatus = HttpStatus.NO_CONTENT.value();

        MessageExceptionModelResponse messageExceptionModelResponse =
                new MessageExceptionModelResponse(httpStatus, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(messageExceptionModelResponse);
    }
}
