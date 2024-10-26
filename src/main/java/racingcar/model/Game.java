package racingcar.model;

public class Game {
    private final Cars cars;
    private final Integer gameRound;

    public final static Integer MAX_GAME_ROUND = 1000;

    public Game(Cars cars, Integer gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public GameResult playRound() {
        this.cars
                .getCars()
                .forEach(Car::moveIfPossible);
        return new GameResult(this.cars);
    }

    public Integer getGameRound() {
        return this.gameRound;
    }
}
