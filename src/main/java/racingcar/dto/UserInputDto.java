package racingcar.dto;

import java.util.List;

public record UserInputDto(
        List<String> carNames,
        int attemptCount
) {
    public static UserInputDto of(List<String> carNames, int attemptCount) {
        return new UserInputDto(carNames, attemptCount);
    }
}
