package racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final Integer gameMatches;

    public RacingGame(Cars cars, Integer gameMatches) {
        this.cars = cars;
        this.gameMatches = gameMatches;
    }

    public Cars getCars() {
        return cars;
    }

    public Integer getGameMatches() {
        return gameMatches;
    }
}
