package br.com.crdc.infra.exception;

public class FormatoInvalidoException extends RuntimeException {
    public FormatoInvalidoException(String message) {
        super(message);
    }
}
