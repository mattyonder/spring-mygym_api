package br.com.gymexercicesapi.repositories;

import br.com.gymexercicesapi.models.MuscleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface MuscleRepository extends JpaRepository<MuscleModel, Long> {

    Optional<MuscleModel> findById(Long idMuscle);

    Optional<MuscleModel> findByName(String name);
}
