package racingcar;

import java.util.List;

public class GameController {
    public void start() {
        try {
            List<String> carNames = InputView.getCarNames();
            int moveCount = InputView.getMoveCount();

            MoveStrategy moveStrategy = new RandomMoveStrategy(new DefaultRandomGenerator());
            RacingGame racingGame = new RacingGame(carNames, moveCount, moveStrategy);

            System.out.println("\n실행 결과");
            racingGame.startRace();

            List<Car> winners = racingGame.getWinners();
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
