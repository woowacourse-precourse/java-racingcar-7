package racingcar.entity;

import java.util.List;

public class Race {
    final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;

        if (cars == null) {
            throw new IllegalArgumentException("자동차 배열은 null이 될 수 없습니다.");
        } else if (10 < cars.size()) {
            throw new IllegalArgumentException("자동차는 10대 이하여야 합니다.");
        } else if (cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public String[] getCarNames() {
        return this.cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

}
