package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;


public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = InputView.inputCarNames();
            int tryCount = InputView.inputTryCount();

            Game racingGame = new Game(carNames);

            ResultView.printExecutionResult();
            for (int i = 0; i < tryCount; i++) {
                racingGame.moveCars();
                ResultView.printRoundResult(racingGame.getCars());
            }

            List<String> winners = racingGame.getWinners();
            ResultView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        close();
    }
}
