package racingcar.dto.response;

import java.util.List;
import java.util.Map;

public record RacingCarResponse(
        List<Map<String, String>> moveRecords,
        String winner
) {
    public static RacingCarResponse from(List<Map<String, String>> moveRecords, String winner) {
        return new RacingCarResponse(moveRecords, winner);
    }
}
