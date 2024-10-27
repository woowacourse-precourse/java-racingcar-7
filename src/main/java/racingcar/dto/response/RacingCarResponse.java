package racingcar.dto.response;

import java.util.List;

public record RacingCarResponse(
        List<String> winners
) {
    public static RacingCarResponse from(List<String> winners) {
        return new RacingCarResponse(winners);
    }
}
