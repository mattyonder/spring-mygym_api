package br.com.gymexercicesapi.models;
import br.com.gymexercicesapi.models.dto.request.MuscleGroupRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_muscle_group")
public class MuscleGroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muscle_group_id")
    private Long id;

    @Column(name = "muscle_group_name")
    private String name;

    @Column(name = "muscle_group_image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "muscleGroup")
    @Column(name = "participating_muscles")
    private List<MuscleModel> participatingMuscles;

    public MuscleGroupModel(MuscleGroupRequest muscleGroupRequest) {
        this.name = muscleGroupRequest.name();
        this.imageUrl = muscleGroupRequest.imageUrl();
    }

}
