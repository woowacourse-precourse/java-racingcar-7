package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNamesInput, int tryCount) {
        this.cars = createCars(carNamesInput);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            race();
            OutputView.printRaceStatus(cars);
        }
        OutputView.printWinners(cars);
    }

    private void race() {
        for (Car car : cars) {
            car.move((int) (Math.random() * 10));
        }
    }
}
