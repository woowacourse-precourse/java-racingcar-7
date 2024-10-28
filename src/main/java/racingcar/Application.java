package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarRaceController;
import racingcar.util.RandomMovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomMovementStrategy randomMovementStrategy = new RandomMovementStrategy();

        CarRaceController carRaceController = new CarRaceController(inputView, outputView, randomMovementStrategy);
        carRaceController.raceStart();

        Console.close();
    }
}
