package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record RacingCarWinner(
        List<String> winnerNames
) {

    public static RacingCarWinner of(final List<Car> cars) {
        return new RacingCarWinner(
                cars.stream()
                        .map(Car::getName)
                        .toList()
        );
    }
}
