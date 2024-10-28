package racingcar.dto;

import java.util.List;

public record RacingCarRequest(List<String> carNames, int moveCount) {
}
