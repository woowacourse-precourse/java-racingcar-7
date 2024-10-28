package racingcar;

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

    private void moveForward(Car car) {
        if (movingCondition.isMovable()) {
            car.moveForward();
        }
    }
}
