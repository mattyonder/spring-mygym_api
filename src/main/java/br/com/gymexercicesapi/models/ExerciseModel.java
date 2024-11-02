package br.com.gymexercicesapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_exercise")
public class ExerciseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "exercise_description")
    private String description;

    @Column(name = "exercise_image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "exercise")
    @Column(name = "activated_muscles")
    private List<ActivatedMusclesModel> activatedMuscles;

}
