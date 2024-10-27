package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarsManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private OutputView outputView;
    private InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
        this.outputView= outputView;
    }

    public void run() {
        try {
            List<String> carNames = new ArrayList<>(inputView.readCarNames());

            int numberOfTrials = inputView.readTrialsCount();

            CarsManager cars = CarsManager.by(carNames);

            outputView.printResult();

            for (int trial = 0; trial < numberOfTrials; trial++) {
                cars.move();
                outputView.printMoving(cars);
            }

        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception);
        }
    }
}

