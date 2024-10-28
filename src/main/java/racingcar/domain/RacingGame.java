package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final GameRule gameRule;
    private int gameCount;

    public void increaseGameCount() {
        this.gameCount += 1;
    }

    public boolean isTimeToEnd() {
        return gameCount == gameRule.getGameLimit();
    }

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
