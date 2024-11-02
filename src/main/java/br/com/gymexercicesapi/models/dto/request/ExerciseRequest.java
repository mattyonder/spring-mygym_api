package br.com.gymexercicesapi.models.dto.request;

import java.util.List;

public record ExerciseRequest(
        String name,
        String description,
        String image,
        List<Long> idMusclesActivated
) {
}
