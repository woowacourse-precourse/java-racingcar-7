package racingcar;

import java.util.List;
import java.util.stream.Collectors;

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

    public void startRace(int attempts) {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputHandler.printRoundResult(cars);
        }
        OutputHandler.printWinners(getWinners());
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }

}
