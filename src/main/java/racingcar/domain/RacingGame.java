package racingcar.domain;

import racingcar.service.RandomNumManager;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final int rounds;
    private final RandomNumManager randomNumManager;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.randomNumManager = new RandomNumManager();
    }

    public void executeRound() {
        for (Car car : cars) {
            int randomNum = RandomNumManager.generateRandomNumber();
            if (RandomNumManager.isSatisfyForwardCondition(randomNum)) {
                car.moveForward();
            }
        }
    }

    public void executeAllRounds(int attempt) {
        for (int i = 0; i < attempt; i++) {
            executeRound();
            OutputView.printRoundResult(cars);
        }
    }
}
