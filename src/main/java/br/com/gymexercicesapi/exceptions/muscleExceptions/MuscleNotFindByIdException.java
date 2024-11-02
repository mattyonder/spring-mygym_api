package br.com.gymexercicesapi.exceptions.muscleExceptions;

public class MuscleNotFindByIdException extends RuntimeException {
    public MuscleNotFindByIdException(String message) {
        super(message);
    }
}
