package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputRound());
        OutputView.printRacingResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.racing();
            OutputView.printRacingCars(racingGame.getCars());
        }
        OutputView.printRaceWinners(racingGame.findWinners());
    }
}
