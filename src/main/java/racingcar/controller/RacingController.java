package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.ResultView;
import racingcar.view.WinnerView;

import java.util.List;

public class RacingController {

    private final InputController inputController;
    private final ResultView resultView;
    private final WinnerView winnerView;

    public RacingController(InputController inputController, ResultView resultView, WinnerView winnerView) {
        this.inputController = inputController;
        this.resultView = resultView;
        this.winnerView = winnerView;
    }

    public void run() {

        InputDTO inputDTO = inputController.getInputView();
        List<Car> carList = inputDTO.carList();
        int inputTurns = inputDTO.turnCount();

        Racing racing = new Racing(carList);

        resultView.printDescription();
        for (int i = 0; i < inputTurns; i++) {
            racing.runRacingTurn();
            resultView.addTurnView(carList);
        }
        resultView.print();

        List<String> winners = racing.computeWinner();
        winnerView.print(winners);

    }

}
