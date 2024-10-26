package racingcar.dto;

import java.util.List;

public record RaceResult(
        List<CarsPositionDto> raceHistory,
        WinnerNamesDto winners
) {
    public static RaceResult of(
            List<CarsPositionDto> raceHistory,
            WinnerNamesDto winners
    ) {
        return new RaceResult(raceHistory, winners);
    }
}