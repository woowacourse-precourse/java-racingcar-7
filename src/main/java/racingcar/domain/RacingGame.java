package racingcar.domain;

import racingcar.strategy.RandomMoveStrategy;

public class RacingGame {
    private static final int FINAL_ROUND_COUNT = 0;
    private static final RandomMoveStrategy RANDOM_MOVE_STRATEGY = new RandomMoveStrategy();

    private final Cars cars;
    private int round;

    public RacingGame(String inputValue, int round) {
        this.cars = initCars(inputValue);
        this.round = round;
    }

    public static Cars initCars(String inputValue) {
        return Cars.from(inputValue);
    }

    public void racing() {
        cars.racing(RANDOM_MOVE_STRATEGY);
        round--;
    }

    public boolean isEnd() {
        return round == FINAL_ROUND_COUNT;
    }

    public Cars getCars() {
        return cars;
    }

    public Winners findWinners() {
        return new Winners(cars);
    }
}
