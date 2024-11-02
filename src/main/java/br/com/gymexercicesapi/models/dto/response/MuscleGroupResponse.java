package br.com.gymexercicesapi.models.dto.response;

import br.com.gymexercicesapi.models.MuscleGroupModel;
import br.com.gymexercicesapi.models.MuscleModel;

import java.util.List;
import java.util.stream.Collectors;

public record MuscleGroupResponse(
        Long id,
        String name,
        String image,
        List<MuscleResponse> participatingMuscles
) {
    public MuscleGroupResponse(MuscleGroupModel muscleGroupModel, List<MuscleResponse> muscleResponses) {
        this(
                muscleGroupModel.getId(),
                muscleGroupModel.getName(),
                muscleGroupModel.getImageUrl(),
                muscleResponses
        );

    }
}
