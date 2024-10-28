package racingcar.dto;

import java.util.List;
import racingcar.model.result.RoundResult;

public record RacingResponseDto(List<RoundResult> roundResults, List<String> winners) {
}
