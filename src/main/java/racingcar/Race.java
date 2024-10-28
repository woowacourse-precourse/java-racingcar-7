package racingcar;

import java.util.List;

public class Race {
    private final List<Car> CARS;
    private final int COUNT;

    Race(List<Car> cars, int count) {
        this.CARS = cars;
        this.COUNT = count;
    }

    public void start() {
        Output.printBlankLine();
        Output.printRunResultMessage();
        for (int i = 0; i < COUNT; i++) {
            for (Car car : CARS) {
                Movement movement = MovementGenerator.getRandomMovement();
                car.move(movement);
            }
            Output.printRunResult(CARS);
        }
    }
}
