package racingcar.dto;

import java.util.List;
import racingcar.model.RoundResult;

public record RacingResponseDto(List<RoundResult> roundResults, List<String> winners) {
}
