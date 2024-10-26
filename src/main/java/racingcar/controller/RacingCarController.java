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
        for (int i = 0; i < service.getMoveCount(); i++) {
            service.playGame();
            OutputView.printGameStatus(service.getGameBoard().getCars());
        }
    }

    public void close() {
        service.determineWinner();
        OutputView.printGameResult(service.getWinners());
    }
}
