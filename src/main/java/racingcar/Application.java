package racingcar;

import racingcar.controller.RacingController;
import racingcar.factory.CarFactory;
import racingcar.util.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputUtil inputUtil = new InputUtil();
        CarFactory carFactory = new CarFactory();
        RacingController racingController = new RacingController(inputView, outputView, inputUtil, carFactory);

        racingController.run();
    }
}
