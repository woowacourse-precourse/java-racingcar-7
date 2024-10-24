package racingcar.model;

public class RacingGame {
    private final Cars cars;
    private final Integer count;

    public RacingGame(Cars cars, Integer count) {
        this.cars = cars;
        this.count = count;
        racingGameTrial(count);
    }

    private void racingGameTrial(Integer count) {
        for (int i = 0; i < count; i++) {
            cars.moveCars();
        }
    }
}
