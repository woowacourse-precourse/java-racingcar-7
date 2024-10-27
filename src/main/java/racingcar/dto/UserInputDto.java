package racingcar.dto;

import java.util.List;

public record UserInputDto(
        List<String> carNames,
        int trialCount
) { }
