package br.com.app.bastoscorreios.adapters.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionModelResponse {

    private int statusCode;
    private String message;
}
