package racingcar.dto.request;

import java.util.List;

public record RacingRequestDTO(
        List<String> carNames,
        Integer moveCount
) {
    public static RacingRequestDTO of(List<String> carNames, Integer moveCount) {
        return new RacingRequestDTO(carNames, moveCount);
    }
}
