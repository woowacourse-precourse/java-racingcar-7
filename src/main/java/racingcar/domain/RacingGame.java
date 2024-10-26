package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final GameRule gameRule;

    public RacingGame(List<Car> cars, GameRule gameRule) {
        this.cars = cars;
        this.gameRule = gameRule;
    }

    public List<Car> getCars() {
        return cars;
    }

    public GameRule getGameRule() {
        return gameRule;
    }
}
