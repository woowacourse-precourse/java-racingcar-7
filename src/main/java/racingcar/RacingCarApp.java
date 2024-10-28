package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarApp {

    private String makeInterimResult(List<Car> cars) {
        return cars.stream()
                .map(Car::convertCurrentStateToString)
                .collect(Collectors.joining("\n"));
    }
}
