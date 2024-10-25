package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record WinnerResult(List<String> winnerNames) {
    public static WinnerResult from(List<Car> winnerCars) {
        return new WinnerResult(winnerCars.stream()
                .map(Car::getName)
                .toList());
    }
}
