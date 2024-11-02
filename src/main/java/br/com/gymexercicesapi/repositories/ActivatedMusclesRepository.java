package br.com.gymexercicesapi.repositories;

import br.com.gymexercicesapi.models.ActivatedMusclesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ActivatedMusclesRepository extends JpaRepository<ActivatedMusclesModel, Long> {
}
