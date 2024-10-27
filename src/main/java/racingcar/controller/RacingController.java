package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.model.Car;
import racingcar.model.Racing;

import java.util.List;

public class RacingController {

    private final InputController inputController;
    private final OutputController outputController;

    public RacingController(InputController inputController, OutputController outputController) {
        this.inputController = inputController;
        this.outputController = outputController;
    }

    public void run() {

        InputDTO inputDTO = inputController.getInputView();
        List<Car> carList = inputDTO.getCarList();
        int inputTurns = inputDTO.getTurnCount();

        Racing racing = new Racing(carList);

        for (int i = 0; i < inputTurns; i++) {
            racing.runRacingTurn();
        }

        List<String> winners = racing.computeWinner();

        outputController.getOutputView(carList, inputTurns, winners);

    }

}
