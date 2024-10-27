package racingcar.dto.response;

import java.util.List;

public record RacingCarWinnerResponse(
        List<String> winners
) {
    public static RacingCarWinnerResponse from(List<String> winners) {
        return new RacingCarWinnerResponse(winners);
    }
}
