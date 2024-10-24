package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> nonDuplicateCar = new HashSet<>(cars);
        if (nonDuplicateCar.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void move() {
        for (Car car : cars) {
            car.isMove();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
