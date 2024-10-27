package racingcar.service;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceLog;

public record RaceResult(
        List<RaceLog> raceLogs,
        List<Car> victoryCars
) {
}
