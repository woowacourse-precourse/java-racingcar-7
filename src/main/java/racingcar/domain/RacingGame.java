package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int tryCount;

    public RacingGame(List<String> carsName, String tryCount) {
        this.cars = initCars(carsName);
        this.tryCount = toInt(tryCount);
    }

    private static int toInt(String tryCount) {
        return Integer.parseInt(tryCount);
    }

    private Cars initCars(List<String> inputNames) {
        return Cars.from(inputNames);
    }

    public void start(MovingStrategy movingStrategy) {
        this.tryCount--;
        moveCars(movingStrategy);
    }

    private void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars.getCars()) {
            car.move(movingStrategy);
        }
    }

    public List<Name> resultWinnerNames() {
        return cars.getWinnerNames(cars.maxPosition());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getTryCount() {
        return tryCount;
    }
}


