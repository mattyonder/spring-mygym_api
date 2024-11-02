package br.com.gymexercicesapi.repositories;

import br.com.gymexercicesapi.models.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ExercisesRepository extends JpaRepository<ExerciseModel, Long> {
}
