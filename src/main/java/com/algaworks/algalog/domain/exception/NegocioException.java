package com.algaworks.algalog.domain.exception;

public class NegocioException extends RuntimeException {

    private static final long serialVerionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }

}
