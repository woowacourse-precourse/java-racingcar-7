package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.util.MovementStrategy;

public class Cars {
    private static final int MAX_CAR_COUNT = 10;

    private final MovementStrategy movementStrategy;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames, MovementStrategy movementStrategy) {
        validateCarCount(carNames.length);
        this.movementStrategy = movementStrategy;
        initializeCars(carNames);
    }

    private void validateCarCount(final int carCount) {
        if (carCount > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 수는 " + MAX_CAR_COUNT + " 이하이어야 합니다.");
        }
    }

    private void initializeCars(final String[] carNames) {
        Arrays.stream(carNames)
                .forEach(carName -> this.cars.add(new Car(carName)));
    }

    public void moveCars() {
        cars.forEach(car -> car.moveIfPossible(movementStrategy.canMove()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
