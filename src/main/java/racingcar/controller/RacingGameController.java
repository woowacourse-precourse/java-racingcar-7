package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TrialCount;
import racingcar.util.CreatingRacingCar;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomGeneratorImpl;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private final RandomGenerator randomGenerator = new RandomGeneratorImpl();

    public void playGame() {
        RacingCars racingCars = createRacingCars();
        TrialCount trialCount = getTrialCount();

        racing(racingCars, trialCount);

        outputView.printRacingCarWinnerResult(racingCars);
    }

    private RacingCars createRacingCars() {
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CreatingRacingCar.createCars(carNames);
    }

    private TrialCount getTrialCount() {
        outputView.printRequestTryCount();
        String trialCount = inputView.inputTrialCount();
        return new TrialCount(trialCount);
    }

    private void racing(RacingCars racingCars, TrialCount trialCount){
        outputView.printExecutionResult();
        for (int i = 0; i < trialCount.getTrialCount(); i++) {
            racingCars.moveAll(randomGenerator);
            outputView.printRoundByExecutionResults(racingCars);
        }
    }
}
