package racingcar.model.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.model.car.Car;

public class CarNameParser {
    private static final int START_POSITION = 0;

    public static List<Car> parseCars(final String input) {
        final String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName, START_POSITION))
                .toList();
    }
}
