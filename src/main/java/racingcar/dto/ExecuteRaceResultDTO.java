package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record ExecuteRaceResultDTO(List<Car> cars, String executeResult) {
}
