package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.service.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        String names = InputView.readNameInput();
        List<String> nameList = Separator.splitNames(names);
        Cars cars = new Cars();
        cars.createCars(nameList);
        int attempt = InputView.readAttemptInput();
        RacingGame racingGame = new RacingGame(cars, attempt);
        OutputView.printExecutionResultMessage();
        racingGame.executeAllRounds(attempt);
        OutputView.printWinner(cars.getWinners());
    }
}
