package racingcar.model.service;

import racingcar.model.domain.Cars;
import racingcar.model.NumberGenerator;
import racingcar.model.domain.GameResult;

import java.util.List;

public class GameService {
    private final Cars cars;
    private final int attemptCount;
    private final GameResult gameResult;

    public GameService(List<String> carNames, int attemptCount, NumberGenerator numberGenerator) {
        this.cars = Cars.from(carNames, numberGenerator);
        this.attemptCount = attemptCount;
        this.gameResult = new GameResult();
    }

    public GameResult playGame() {
        for (int i = 0; i < attemptCount; i++) {
            playRound();
        }
        gameResult.saveWinner(cars);
        return gameResult;
    }

    private void playRound() {
        cars.moveForward();
        gameResult.saveRound(cars);
    }
}
