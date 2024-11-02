package br.com.gymexercicesapi.exceptions.muscleGroupExceptions;

public class MuscleGroupNotFindByIdException extends RuntimeException {
    public MuscleGroupNotFindByIdException(String message) {
        super(message);
    }
}
