package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = InputView.getCarNames();
            int moveCount = InputView.getMoveCount();

            MoveStrategy moveStrategy = new RandomMoveStrategy(new DefaultRandomGenerator());
            RacingGame racingGame = new RacingGame(carNames, moveCount, moveStrategy);

            System.out.println("\n실행 결과");
            racingGame.startRace();
            for (int i = 0; i < moveCount; i++) {
                OutputView.printRoundResult(racingGame.getCars());
            }

            List<Car> winners = racingGame.getWinners();
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
