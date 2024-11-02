package br.com.gymexercicesapi.models.dto.response;

import java.util.List;

public record ExerciseResponse(
        Long id,
        String name,
        String imageUrl,
        List<ActivatedMusclesResponse> activatedMuscles
) {
}
