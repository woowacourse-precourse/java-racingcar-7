package racingcar.controller;

import racingcar.model.CarMovement;
import racingcar.model.Input;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingcarController {
    private final InputController inputController;
    private final MoveController moveController;
    private final OutputView outputView;

    public RacingcarController() {
        InputView inputView = new InputView();
        this.inputController = new InputController(inputView);
        this.outputView = new OutputView();

        CarMovement carMovement = new CarMovement();
        this.moveController = new MoveController(carMovement);
    }

    public void run() {
        Input input = inputController.getInput();

        List<String> carNames = input.getCarNames();
        int tryCount = input.getTryCount();

        Race race = new Race(carNames);
        moveController.runMove(race, tryCount);

        List<String> winners = race.getWinners();
        OutputView.printWinners(winners);

    }
}
