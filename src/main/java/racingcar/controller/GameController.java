package racingcar.controller;

import racingcar.exception.CarNameValidator;
import racingcar.exception.RoundValidator;
import racingcar.service.StringService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StringService stringService;
    private final CarNameValidator carNameValidator;
    private final RoundValidator roundValidator;

    public GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.stringService = new StringService();
        this.carNameValidator = new CarNameValidator();
        this.roundValidator = new RoundValidator();
    }

    public void setGame() {
        outputView.startMessage();
        String carNames = inputView.userInput();

        String[] carNameList = stringService.splitString(carNames);
        carNameValidator.validateCarName(carNameList);

        String roundInput = inputView.userInput();
        int round = roundValidator.validateRound(roundInput);
    }
}
