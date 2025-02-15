package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView() {};
        OutputView outputView = new OutputView();

        RandomGenerator randomGenerator = new RandomGeneratorImpl();

        CarRaceController carRaceController = new CarRaceController(inputView, outputView, randomGenerator);
        carRaceController.run();
    }
}
