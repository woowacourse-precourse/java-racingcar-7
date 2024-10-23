package racingcar;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void start(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            moveCars();
            printRaceStatus();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
