package br.com.gymexercicesapi.models.dto.request;

import br.com.gymexercicesapi.models.enums.ActivationLevel;

public record ActivatedMusclesRequest(
        Long exerciseId,
        Long muscleId,
        ActivationLevel activationLevel
) {
}
