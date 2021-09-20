package br.com.app.bastoscorreios.application.exception;

public class BadBusyException extends RuntimeException {

    public BadBusyException(String mensage) {
        super(mensage);
    }
}
