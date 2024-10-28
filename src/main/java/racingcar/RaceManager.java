package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private final List<Car> cars;
    private final int attemptCount;

    public RaceManager(List<String> carNames, int attemptCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.attemptCount = attemptCount;
    }

    public void runRace() {
        for (int i = 0; i < attemptCount; i++) {
            System.out.println("\n라운드 " + (i + 1));
            for (Car car : cars) {
                car.move();
                System.out.println(car);
            }
        }
        WinnerPrinter.printWinners(cars);
    }
}
