package racingcar.controller;

import racingcar.dto.InputDTO;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final InputController inputController;
    private final OutputView outputView;

    public RacingController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

        InputDTO inputDTO = inputController.getInput();
        String[] carNameList = inputDTO.getCarNameList();
        int inputTurns = inputDTO.getTurnCount();

        List<Car> carList = new ArrayList<>();
        for (final String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        Racing racing = new Racing(carList);

        for (int i = 0; i < inputTurns; i++) {
            racing.runRacingTurn();
        }

        List<String> winners = racing.computeWinner();

        outputView.printResultMessage();

        for (int i = 1; i <= inputTurns; i++) {
            for (final Car car : carList) {
                outputView.printResult(car.getName(), car.getDistance(i));
            }
            System.out.println();
        }

        outputView.winnerView(winners);
    }

}
