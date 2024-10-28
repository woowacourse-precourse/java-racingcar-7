package racingcar.controller;

import racingcar.service.CarService;
import racingcar.service.MoveCountService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarService service = new CarService();
    private final MoveCountService moveCountService = new MoveCountService();

    public void handleInputCarNames() {
        InputView.printCarNamesInputGuide();
        service.createGame(InputView.inputCarNames());
    }

    public void handleInputMoveCount() {
        InputView.printMoveCountInputGuide();
        moveCountService.setMoveCount(InputView.inputMoveCount());
    }

    public void startGame() {
        handleInputCarNames();
        handleInputMoveCount();

        OutputView.printRunMessage();
        for (int i = 0; i < moveCountService.getMoveCount(); i++) {
            service.playGame();
            OutputView.printGameStatus(service.getCarList().getCars());
        }

        service.determineWinner();
        OutputView.printGameResult(service.getWinners());
    }
}