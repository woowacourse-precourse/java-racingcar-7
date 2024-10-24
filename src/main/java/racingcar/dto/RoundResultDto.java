package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record RoundResultDto(
        int roundNumber,
        List<Car> carList
) {
}
