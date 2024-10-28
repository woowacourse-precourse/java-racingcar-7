package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.result.ResultCalculator;
import racingcar.service.CarSetupService;
import racingcar.service.RacingGameService;

public class GameController {
    private List<Car> cars;
    private final RacingGameService racingGameService = new RacingGameService();
    private final ResultCalculator resultCalculator = new ResultCalculator();
    private final CarSetupService carSetupService = new CarSetupService();

    public void startGame() {
        String carNamesInput = InputView.InputCarNames();
        cars = carSetupService.setupCars(carNamesInput);
        int roundCount = InputView.InputRoundNumber();
        runRounds(roundCount);
        endGame();
    }

    private void runRounds(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            runSingleRound();
        }
    }

    private void runSingleRound() {
        racingGameService.runRound(cars);
        OutputView.printRoundResults(cars);
    }

    public void endGame() {
        List<String> winners = resultCalculator.determineWinners(cars);
        OutputView.printWinners(winners);
    }
}
