package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.accelerator.Accelerator;

public class CarCollection {

    private final List<Car> cars;

    CarCollection(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void accelerateAll(Accelerator accelerator) {
        for (Car car : cars) {
            car.accelerate(accelerator);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
