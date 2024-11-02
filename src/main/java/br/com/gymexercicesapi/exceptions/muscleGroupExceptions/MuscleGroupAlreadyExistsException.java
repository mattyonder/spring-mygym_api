package br.com.gymexercicesapi.exceptions.muscleGroupExceptions;

public class MuscleGroupAlreadyExistsException extends RuntimeException {
    public MuscleGroupAlreadyExistsException(String message) {
        super(message);
    }
}
