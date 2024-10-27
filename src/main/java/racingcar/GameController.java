package racingcar;

import java.util.List;

public class GameController {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public GameController(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.move();
            }
        }
    }
}
