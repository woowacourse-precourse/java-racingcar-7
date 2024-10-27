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
            System.out.println(carNames);

            int TrialCounts = inputView.readTrialsCount();
            System.out.println(TrialCounts);

            CarsManager cars = CarsManager.by(carNames);
        }catch(IllegalArgumentException exception){
            outputView.printExceptionMessage(exception);
        }
    }
}

