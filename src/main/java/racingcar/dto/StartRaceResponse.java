package racingcar.dto;

import java.util.List;
import java.util.Map;

public record StartRaceResponse(
        List<Map<String, Integer>> roundMoveData
) {
}