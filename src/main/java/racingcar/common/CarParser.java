package racingcar.common;

import java.util.List;
import racingcar.domain.Car;

public class CarParser {

    public static String convertCarsToNames(final List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        return InputSplitter.join(carNames);
    }
}
