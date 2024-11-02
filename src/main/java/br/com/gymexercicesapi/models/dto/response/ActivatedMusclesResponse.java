package br.com.gymexercicesapi.models.dto.response;

import br.com.gymexercicesapi.models.ActivatedMusclesModel;
import br.com.gymexercicesapi.models.enums.ActivationLevel;

public record ActivatedMusclesResponse(
        Long id,
        String exerciseName,
        String muscleName,
        ActivationLevel activationLevel
) {
}
