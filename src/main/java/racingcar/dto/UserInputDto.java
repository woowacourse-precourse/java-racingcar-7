package racingcar.dto;

import java.util.List;

public record UserInputDto(
        List<String> parsedCarNames,
        int validatedTrialCount
) { }
