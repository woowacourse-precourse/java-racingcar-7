package racingcar.controller;

import racingcar.model.domain.GameEnvironment;
import racingcar.model.service.RacingcarService;
import racingcar.view.InputView;

public class RacingcarController {

    private final InputView inputView;
    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.inputView = new InputView();
        this.racingcarService = new RacingcarService(new GameEnvironment());
    }

    public String getCarNames() {
        inputView.printGetCarNamesMessage();

        String carNamesInput = inputView.getInput();
        racingcarService.saveCars(carNamesInput);

        return "success";
    }

    public String getAttemptCount() {
        inputView.printGetAttemptCountMessage();

        String attemptCountInput = inputView.getInput();
        racingcarService.saveAttemptCount(attemptCountInput);

        return "success";
    }
}
