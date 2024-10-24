package racingcar.domain.round;

import java.util.List;
import racingcar.domain.car.Car;

public record RoundSnapshot(List<RoundResult> roundResult, int maxPosition) {

    public static RoundSnapshot from(List<Car> cars) {
        List<RoundResult> roundResult = cars.stream()
                .map(Car::toRoundResult)
                .toList();

        return new RoundSnapshot(roundResult, extractMaxPosition(roundResult));
    }

    private static int extractMaxPosition(List<RoundResult> roundResult) {
        return roundResult.stream()
                .mapToInt(RoundResult::position)
                .max()
                .orElse(0);
    }

}
