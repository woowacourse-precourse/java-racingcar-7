package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.valuegenerator.ValueGenerator;

public class Cars {
    private static final int DEFAULT_POSITION = 0;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars valueOf(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());

        return new Cars(cars);
    }

    public List<String> getExecutionResult() {
        return cars.stream()
                .map(ExecutionResult::ofValue)
                .map(Object::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getTotalResult() {
        Integer maxPositionValue = cars
                .stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(DEFAULT_POSITION);

        return cars.stream()
                .filter(car -> maxPositionValue.equals(car.getPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveEachRandomly(ValueGenerator valueGenerator) {
        cars.stream()
                .filter(car -> valueGenerator.getValue() >= 4)
                .forEach(Car::increasePosition);
    }
}
