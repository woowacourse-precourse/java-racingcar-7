package racingcar;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    Set<Car> cars = new HashSet<>();

    public void run(final String carNames, final int totalMoves) {
        for (String name : carNames.split(",")) {
            registerCar(new Car(name));
        }
    }

    private void registerCar(Car car) {
        boolean isAdded = cars.add(car);
        validateNameDuplicated(isAdded);
    }

    private void validateNameDuplicated(final boolean isAdded) {
        if (!isAdded) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다");
        }
    }
}
