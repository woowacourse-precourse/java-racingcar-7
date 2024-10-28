package racingcar;

import racingcar.common.GameSettings;
import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.validation.InputViewValidator;
import racingcar.validation.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameFactory {
    private static final InputViewValidator inputViewValidator = new InputViewValidator();
    private static final InputView inputView = new InputView(inputViewValidator);
    private static final OutputView outputView = new OutputView();
    private static final RacingGameService service = new RacingGameService(createGameSettings());
    private static final CarNameValidator carNameValidator = new CarNameValidator();

    private static GameSettings createGameSettings() {
        int randomMinValue = 0;
        int randomMaxValue = 9;
        int moveThreshold = 4;
        return new GameSettings(randomMinValue, randomMaxValue, moveThreshold);
    }

    public RacingGameController initializeController() {
        return new RacingGameController(inputView, outputView, service, carNameValidator);
    }
}
