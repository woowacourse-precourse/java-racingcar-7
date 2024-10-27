package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> drawWinner() {
        Car carAtMaxPosition = getCarAtMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePositionAs(carAtMaxPosition))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    private Car getCarAtMaxPosition() {
        Car carAtMaxPosition = cars.getFirst();

        for (Car car : cars) {
            if (car.isPositionGreaterThan(carAtMaxPosition)) {
                carAtMaxPosition = car;
            }
        }
        return carAtMaxPosition;
    }
}
