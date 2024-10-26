package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceLog;

public record RaceResult(
        List<RaceLog> raceLogs,
        List<Car> victoryCars
) {
}
