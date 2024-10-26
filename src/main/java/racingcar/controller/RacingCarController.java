package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarService service = new CarService();

    public void init() {
        handleInputCarNames();
        handleInputMoveCount();
    }

    public void handleInputCarNames() {
        OutputView.printCarNamesInputGuide();
        service.createGame(InputView.inputCarNames());
    }

    public void handleInputMoveCount() {
        OutputView.printMoveCountInputGuide();
        service.setMoveCount(InputView.inputMoveCount());
    }

    public void run() {
        OutputView.printRunMessage();
    }
}
