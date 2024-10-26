package racingcar;

import racingcar.controller.CarController;
import racingcar.service.CarMoveManager;
import racingcar.service.InputSplitter;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarMoveManager carMoveManager = new CarMoveManager();
        InputSplitter inputSplitter = new InputSplitter();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CarController carController = new CarController(carMoveManager, inputSplitter, randomNumberGenerator,
                inputView, outputView);

        carController.play();
    }
}
