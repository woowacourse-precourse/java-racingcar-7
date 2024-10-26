package racingcar.dto.response;

import java.util.List;

public record RaceResponse(
        List<String> winners
) {
    public static RaceResponse from(List<String> winners) {
        return new RaceResponse(winners);
    }
}
