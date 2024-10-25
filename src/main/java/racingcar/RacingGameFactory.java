package racingcar;

import racingcar.common.GameSettings;
import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.validation.InputViewValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameFactory {
    private static final InputViewValidator inputViewValidator = new InputViewValidator();
    private static final InputView inputView = new InputView(inputViewValidator);
    private static final OutputView outputView = new OutputView();
    private static final GameSettings settings = new GameSettings(0, 9, 4);
    private static final RacingGameService service = new RacingGameService(settings);

    public RacingGameController initializeController() {
        return new RacingGameController(inputView, outputView, service);
    }
}
