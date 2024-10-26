package racingcar.dto;

import java.util.List;
import java.util.Map;

public record RacingResponse(
        List<Map<String, Integer>> moveData,
        List<String> winner
) {
}