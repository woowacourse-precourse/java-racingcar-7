package racingcar.model;

public class GameResult {
    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return this.cars;
    }

}
