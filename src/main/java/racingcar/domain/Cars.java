package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateDuplicated(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.canMove()));
    }

    private void validateDuplicated(List<Car> cars) {
        if (cars.size() > new HashSet<>(cars).size()) {
            throw new IllegalArgumentException("자동차는 중복될 수 없습니다.");
        }
    }
}
