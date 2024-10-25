package racingcar.model;

public class GameResult {
    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return this.cars;
    }

    public Integer findMaxMoveCount() {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}
