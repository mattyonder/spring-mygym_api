package br.com.gymexercicesapi.models;

import br.com.gymexercicesapi.models.enums.ActivationLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_activated_muscles")
public class ActivatedMusclesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activated_muscle_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private ExerciseModel exercise;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    private MuscleModel muscle;

    @Column(name = "activated_muscle_activation_level")
    private ActivationLevel activationLevel;

}
