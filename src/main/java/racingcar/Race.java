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

    public List<Car> end() {
        int maxPosition = CARS.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return CARS.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private void run(){
        CARS.forEach(car -> car.move(MovementGenerator.getRandomMovement()));
        Output.printRunResult(CARS);
    }
}
