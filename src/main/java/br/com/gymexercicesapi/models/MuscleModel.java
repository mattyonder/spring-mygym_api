package br.com.gymexercicesapi.models;

import br.com.gymexercicesapi.models.dto.request.MuscleGroupRequest;
import br.com.gymexercicesapi.models.dto.request.MuscleRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_muscle")
public class MuscleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muscle_id")
    private Long id;

    @Column(name = "muscle_name")
    private String name;

    @Column(name = "muscle_image_url")
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(name = "muscle_group_id")
    private MuscleGroupModel muscleGroup;

    @OneToMany(mappedBy = "muscle")
    @Column(name = "exercises_that_activate")
    private List<ActivatedMusclesModel> exercisesThatActivate;


    public MuscleModel(MuscleRequest muscleRequest, MuscleGroupModel muscleGroupModel) {
        this.name = muscleRequest.name();
        this.imageUrl = muscleRequest.imageUrl();
        this.muscleGroup = muscleGroupModel;
    }
}
