package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.winner.RacingWinnerFinder;
import racingcar.game.winner.Winner;

import java.util.List;

public class RacingGame {
    private static final int END_OF_ATTEMPT = 0;
    private static final int MAX_DISTANCE = 1;

    private final GameRule rule;
    private final RacingWinnerFinder winnerFinder;
    private final RacingGameLogger logger;

    public RacingGame(GameRule rule, RacingWinnerFinder winnerFinder, RacingGameLogger logger) {
        this.rule = rule;
        this.winnerFinder = winnerFinder;
        this.logger = logger;
    }

    public Winner play(List<Car> playerCars, int attempts) {
        if(playerCars.isEmpty() || attempts <= END_OF_ATTEMPT)
            throw new IllegalArgumentException();

        logger.logStartMessage();
        while (attempts-- > END_OF_ATTEMPT) {
            playTurn(playerCars);
            logger.logProgress(playerCars);
        }
        Winner winner = winnerFinder.find(playerCars);
        logger.logWinner(winner);
        return winner;
    }

    private void playTurn(List<Car> playerCars) {
        for (Car playerCar : playerCars) {
            if(rule.canMove()) {
                playerCar.move(MAX_DISTANCE);
            }
        }
    }
}
