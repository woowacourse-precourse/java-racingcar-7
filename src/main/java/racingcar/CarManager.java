package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.condition.MovingCondition;

public class CarManager {

    private final MovingCondition movingCondition;

    public CarManager(MovingCondition movingCondition) {
        this.movingCondition = movingCondition;
    }

    public void moveCarsForward(List<Car> cars) {
        cars.forEach(this::moveForward);
    }

    public List<Car> makeCarsFromText(String text) {
        return Arrays.stream(text.split(","))
                .map(Car::new)
                .toList();
    }

    private void moveForward(Car car) {
        if (movingCondition.isMovable()) {
            car.moveForward();
        }
    }
}
