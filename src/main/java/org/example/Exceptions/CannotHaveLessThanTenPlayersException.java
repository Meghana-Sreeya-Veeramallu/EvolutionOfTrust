package org.example.Exceptions;

public class CannotHaveLessThanTenPlayersException extends RuntimeException {
    public CannotHaveLessThanTenPlayersException(String message) {
        super(message);
    }
}
