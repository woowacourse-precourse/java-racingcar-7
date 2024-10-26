package racingcar.model;

public class Game {
    private final Cars cars;
    private final Integer gameRound;
    public final static Integer MAX_GAME_ROUND = 1000;

    public Game(Cars cars, Integer gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    public GameResult playGame() {
        GameResult result = new GameResult();
        for (int round = 0; round < gameRound; round++) {
            GameRoundResult roundResult = playRound();
            result.saveRoundResult(roundResult);
        }
        return result;
    }

    public GameRoundResult playRound() {
        this.cars
                .getCars()
                .forEach(Car::moveIfPossible);
        return new GameRoundResult(this.cars);
    }

    public Integer getGameRound() {
        return this.gameRound;
    }


}
