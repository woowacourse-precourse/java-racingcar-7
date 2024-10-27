package racingcar;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int moveCount;

    public Race(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void playRacing() {
        for (int i = 0; i < moveCount; i++) {
            carsMove();
        }
    }

    private void carsMove() {
        for (Car car : cars) {
            car.moveCar();
        }
    }
}
