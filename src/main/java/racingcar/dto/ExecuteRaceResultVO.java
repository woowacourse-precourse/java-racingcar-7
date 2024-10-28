package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record ExecuteRaceResultVO(List<Car> cars, String executeResult) {
}
