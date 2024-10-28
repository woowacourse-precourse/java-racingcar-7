package racingcar.model.car;

import java.util.List;
import racingcar.model.race.strategy.MoveStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carsNames) {
        cars = carsNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCarsIfAble(MoveStrategy strategy) {
        for (Car car : cars) {
            if (strategy.canMove()) {
                car.moveForward();
            }
        }
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
