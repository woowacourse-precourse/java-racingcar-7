package racingcar.application.dto.response;

import static racingcar.domain.race.constants.RaceFormat.*;

public record RaceResponse(String raceResult, String winners) implements Response {

    @Override
    public String toString() {
        return RACE_RESULT.generate(raceResult) + FINAL_WINNER.generate(winners);
    }
}
