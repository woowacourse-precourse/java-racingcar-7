package racingcar;

import java.util.List;

public class Race {
    private final List<Car> CARS;
    private final int COUNT;

    Race(List<Car> cars, int count) {
        this.CARS = cars;
        this.COUNT = count;
    }

    public void start(){
        for (int i = 0; i < COUNT; i++) {
            run();
        }
    }

    private void run(){
        CARS.forEach(car -> car.move(MovementGenerator.getRandomMovement()));
        Output.printRunResult(CARS);
    }
}
