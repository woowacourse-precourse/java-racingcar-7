package racingcar.racing;

import static racingcar.common.FormatConstants.LINE_BREAKER;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceHistoryWriter {

    public String writeAll(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(LINE_BREAKER));
    }
}
