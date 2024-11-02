package br.com.gymexercicesapi.exceptions.muscleExceptions;

public class MuscleNotFindByNameException extends RuntimeException {
    public MuscleNotFindByNameException(String message) {
        super(message);
    }
}
