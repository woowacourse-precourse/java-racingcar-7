package racingcar.dto;

import racingcar.domain.race.RaceResult;

public class RaceResultDTO {

    private final RaceResult raceResult;

    public RaceResultDTO(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    public RaceResult getRaceResult() {
        return raceResult;
    }
}
