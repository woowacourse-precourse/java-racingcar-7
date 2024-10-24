package racingcar.application;

import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.game.RaceRounds;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.ScoreBoard;

public class RacingService {
    private final MovingStrategy movingStrategy;

    public RacingService(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public ScoreBoard getRacingResult(String carNames, String rawCountInput) {
        Cars cars = Cars.of(carNames, movingStrategy);
        RaceRounds raceRounds = RaceRounds.of(rawCountInput);
        RacingGame racingGame = new RacingGame(cars, raceRounds, ScoreBoard.ofEmpty());
        return racingGame.play();
    }
}
