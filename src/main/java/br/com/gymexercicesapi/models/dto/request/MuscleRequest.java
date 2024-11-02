package br.com.gymexercicesapi.models.dto.request;

public record MuscleRequest(
        String name,
        String imageUrl,
        Long idMuscleGroup
) {
}
