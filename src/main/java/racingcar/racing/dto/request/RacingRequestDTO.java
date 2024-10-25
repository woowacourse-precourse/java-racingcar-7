package racingcar.racing.dto.request;

import java.util.List;

public record RacingRequestDTO(List<String> carNames, Integer round) {
}
