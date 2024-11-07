package br.com.gymexercicesapi.services;

import br.com.gymexercicesapi.repositories.ExercisesRepository;
import org.springframework.stereotype.Service;

@Service
public class ExercisesService {

    private final ExercisesRepository exercisesRepository;

    public ExercisesService(ExercisesRepository exercisesRepository){
        this.exercisesRepository = exercisesRepository;
    }

    public void save ()

}
