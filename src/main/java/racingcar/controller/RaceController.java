package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String userInput = inputView.CarNamesInput();
        int attemptsNum = inputView.attemptsNumInput();

        Cars cars = new Cars(Cars.makeCarList(userInput));

        outputView.showExecuteMessage();
        for (int attempt = 0; attempt < attemptsNum; attempt++) {
            cars.forwardWithRandomCondition();
            outputView.showStatus(cars);
        }

        List<String> winnersName = cars.findWinners();
        outputView.showWinners(winnersName);
    }
}
