package racingcar.model;

public class Game {
    private final Cars cars;
    private final Integer gameRound;

    public Game(Cars cars, Integer gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }
}
