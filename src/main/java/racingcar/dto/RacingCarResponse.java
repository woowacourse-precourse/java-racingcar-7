package racingcar.dto;

import java.util.List;
import java.util.Map;

public record RacingCarResponse(List<Map<String, Integer>> racingResults, List<String> winnerNames) {
}
