package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.strategy.MoveStrategy;

public class Cars {
    private static final String DUPLICATE_ERROR = "자동차 이름은 중복될 수 없습니다.";
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicated(cars);
        this.cars = cars;
    }

    public static Cars from(String inputValue) {
        List<Car> cars = Arrays.stream(inputValue.split(DELIMITER))
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    private void validateDuplicated(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public void racing(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy.isMovable()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
