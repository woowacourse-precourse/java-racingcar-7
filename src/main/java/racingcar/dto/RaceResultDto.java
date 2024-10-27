package racingcar.dto;

import java.util.List;

public record RaceResultDto(
        List<CarsPositionDto> raceHistory,
        WinnerNamesDto winners
) {
    public static RaceResultDto of(
            List<CarsPositionDto> raceHistory,
            WinnerNamesDto winners
    ) {
        return new RaceResultDto(raceHistory, winners);
    }
}
