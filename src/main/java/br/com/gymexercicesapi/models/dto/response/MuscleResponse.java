package br.com.gymexercicesapi.models.dto.response;
import br.com.gymexercicesapi.models.MuscleModel;

import java.util.List;

public record MuscleResponse (
        Long id,
        String name,
        String imageUrl,
        String muscleGroup
) {
    public MuscleResponse(MuscleModel muscleModel) {
        this(
                muscleModel.getId(),
                muscleModel.getName(),
                muscleModel.getImageUrl(),
                muscleModel.getMuscleGroup().getName()
                );
    }
}
