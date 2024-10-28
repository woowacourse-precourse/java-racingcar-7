package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.ParseCarNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ParseCarNames parseCarNames = new ParseCarNames();
        RacingController racingController = new RacingController(inputView, outputView, parseCarNames);

        racingController.run();
    }
}
