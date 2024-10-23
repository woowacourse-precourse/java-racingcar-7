package racingcar;

import racingcar.controller.ApplicationController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        ApplicationController.run(new InputView(), new OutputView());
    }
}
