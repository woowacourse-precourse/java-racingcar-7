package racingcar.domain;

import racingcar.strategy.RandomMoveStrategy;

public class RacingGame {
    private static final RandomMoveStrategy RANDOM_MOVE_STRATEGY = new RandomMoveStrategy();

    private final Cars cars;
    private Round round;

    public RacingGame(String inputValue, Round round) {
        this(initCars(inputValue), round);
    }

    public RacingGame(String inputValue, int round) {
        this(inputValue, new Round(round));
    }

    public static Cars initCars(String inputValue) {
        return Cars.from(inputValue);
    }

    private RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void racing() {
        cars.racing(RANDOM_MOVE_STRATEGY);
        round = round.nextRound();
    }

    public Cars getCars() {
        return cars;
    }

    public Winners findWinners() {
        return new Winners(cars);
    }

    public boolean isEnd() {
        return round.isEnd();
    }
}
