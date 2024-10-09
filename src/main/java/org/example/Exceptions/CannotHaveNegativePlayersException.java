package org.example.Exceptions;

public class CannotHaveNegativePlayersException extends RuntimeException {
    public CannotHaveNegativePlayersException(String message) {
        super(message);
    }
}
