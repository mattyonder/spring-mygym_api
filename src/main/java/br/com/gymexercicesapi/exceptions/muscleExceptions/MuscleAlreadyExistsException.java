package br.com.gymexercicesapi.exceptions.muscleExceptions;

public class MuscleAlreadyExistsException extends RuntimeException {
    public MuscleAlreadyExistsException(String message) {
        super(message);
    }
}
