package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.valuegenerator.ValueGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
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

    public void move(ValueGenerator valueGenerator) {
        cars.stream()
                .filter(car -> valueGenerator.getValue() >= 4)
                .forEach(Car::increasePosition);
    }
}
