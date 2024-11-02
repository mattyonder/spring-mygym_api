package br.com.gymexercicesapi.repositories;

import br.com.gymexercicesapi.models.MuscleGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface MuscleGroupRepository extends JpaRepository<MuscleGroupModel, Long>{

    Optional<MuscleGroupModel> findById(Long idMuscleGroup);

    Optional<MuscleGroupModel> findByName(String name);

}
