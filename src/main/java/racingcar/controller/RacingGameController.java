package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TrialCount;
import racingcar.util.CreatingRacingCar;
import racingcar.view.InformationView;
import racingcar.view.InputView;

public class RacingGameController {
    private InformationView informationView = new InformationView();
    private InputView inputView = new InputView();

    public void playGame() {
        RacingCars racingCars = createRacingCars();
        TrialCount trialCount = getTrialCount();
    }

    private RacingCars createRacingCars() {
        informationView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CreatingRacingCar.createCars(carNames);
    }

    private TrialCount getTrialCount() {
        informationView.printRequestTryCount();
        String trialCount = inputView.inputTrialCount();
        return new TrialCount(trialCount);
    }
}
