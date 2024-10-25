package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = getCarNames();
        int rounds = getNumberOfRounds();

        RacingCars racingCars = RacingCars.init(carNames);
        outputView.printResultMessage();

        for (int i = 0; i < rounds; i++) {
            racingCars = racingCars.move();
            outputView.printCarsLocation(racingCars);
        }
    }

    private int getNumberOfRounds() {
        outputView.printAskingForNumberOfRounds();
        return inputView.askForNumberOfRounds();
    }

    private List<String> getCarNames() {
        outputView.printAskingForCarNames();
        return inputView.askForCarNames();
    }
}
