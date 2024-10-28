package racingcar.domain;

import racingcar.domain.movestrategy.MoveStrategy;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(moveStrategy::move);
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
