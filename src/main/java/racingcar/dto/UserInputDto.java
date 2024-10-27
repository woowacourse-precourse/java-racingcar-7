package racingcar.dto;

import java.util.List;

public record UserInputDto(
        List<String> carNames,
        int epoch
) {
    public static UserInputDto of(List<String> carNames, int epoch) {
        return new UserInputDto(carNames, epoch);
    }
}
