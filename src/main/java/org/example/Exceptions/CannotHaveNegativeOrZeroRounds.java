package org.example.Exceptions;

public class CannotHaveNegativeOrZeroRounds extends RuntimeException {
    public CannotHaveNegativeOrZeroRounds(String message) {
        super(message);
    }
}
