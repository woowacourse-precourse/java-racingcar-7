package racingcar.controller;

import racingcar.service.StringService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final StringService stringService;

    public GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.stringService = new StringService();
    }

    public void startGame() {
        outputView.startMessage();
        String carNames = inputView.userInput();

        String[] carNameList = stringService.splitString(carNames);
    }
}
