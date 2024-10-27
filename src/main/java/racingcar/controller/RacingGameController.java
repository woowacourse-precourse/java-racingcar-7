package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TrialCount;
import racingcar.util.CreatingRacingCar;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void playGame() {
        RacingCars racingCars = createRacingCars();
        TrialCount trialCount = getTrialCount();
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
}
