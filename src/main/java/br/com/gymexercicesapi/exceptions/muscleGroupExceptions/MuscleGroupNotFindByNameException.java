package br.com.gymexercicesapi.exceptions.muscleGroupExceptions;

public class MuscleGroupNotFindByNameException extends RuntimeException {
    public MuscleGroupNotFindByNameException(String message) {
        super(message);
    }
}
