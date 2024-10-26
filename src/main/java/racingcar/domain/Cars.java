package racingcar.domain;

import static racingcar.constant.ExceptionMessage.NO_CARS;

import java.util.List;
import racingcar.strategy.MovingStrategy;
import racingcar.util.EnhancedList;

public class Cars {
    private final EnhancedList<Car> value;

    private Cars(EnhancedList<Car> cars) {
        validateNotEmpty(cars);
        this.value = cars;
    }

    public static Cars from(List<Car> value) {
        return new Cars(
                new EnhancedList<Car>(value)
        );
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(NO_CARS.message());
        }
    }

    public void attemptMoveAll(MovingStrategy movingStrategy) {
        value.forEach(car -> car.attemptMove(movingStrategy));
    }

    public List<Car> getCarsWithMaxStep() {
        return value.maxAll();
    }
}
