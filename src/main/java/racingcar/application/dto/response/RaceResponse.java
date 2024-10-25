package racingcar.application.dto.response;

import static racingcar.infrastructure.constants.AnnounceMessages.*;

public record RaceResponse(String raceResult, String winners) implements Response {

    @Override
    public String toString() {
        return RESULT.getMessage() +
            NEW_LINE.getMessage() +
            raceResult +
            WINNER.getMessage() +
            winners;
    }
}
