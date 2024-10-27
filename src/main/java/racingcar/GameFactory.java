package racingcar;

import racingcar.controller.GameController;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameFactory {
    private GameFactory() {

    }

    public static GameController createGame() {
        CarNameValidator carNameValidator = new CarNameValidator();
        TrialCountValidator trialCountValidator = new TrialCountValidator();
        InputView inputView = new InputView(carNameValidator, trialCountValidator);
        OutputView outputView = new OutputView();

        return new GameController(inputView, outputView);
    }
}
