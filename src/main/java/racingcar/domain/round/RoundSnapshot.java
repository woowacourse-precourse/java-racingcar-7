package racingcar.domain.round;

import java.util.List;
import racingcar.domain.car.Car;

public record RoundSnapshot(List<RoundResult> roundResult) {

    public static RoundSnapshot from(List<Car> cars) {
        List<RoundResult> roundResult = cars.stream()
                .map(Car::toRoundResult)
                .toList();

        return new RoundSnapshot(roundResult);
    }

}
