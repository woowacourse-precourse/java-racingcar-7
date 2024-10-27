package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.valuegenerator.RandomValueGenerator;

public class Cars {
    private final List<Car> cars;
    private final RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars valueOf(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());

        return new Cars(cars);
    }

    public void move() {
        cars.stream()
                .filter(car -> randomValueGenerator.getValue() >= 4)
                .forEach(Car::increasePosition);
    }
}
