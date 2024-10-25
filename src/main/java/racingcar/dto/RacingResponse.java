package racingcar.dto;

import java.util.List;
import java.util.Map;

public record RacingResponse(
        Map<String, List<Integer>> race,
        List<String> winner
) {
}
