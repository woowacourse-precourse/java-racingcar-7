package racingcar.domain.car;

import java.util.List;
import java.util.function.IntSupplier;

public class CarGenerator {

    private CarGenerator() {}

    public static Cars generateCars(List<String> carNames, IntSupplier engine) {
        List<Car> cars = carNames.stream()
                .map(carName -> Car.of(carName, engine))
                .toList();

        return new Cars(cars);
    }
}
