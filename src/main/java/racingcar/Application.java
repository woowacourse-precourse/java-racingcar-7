package racingcar;

import racingcar.controller.Controller;
import racingcar.model.TextFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(),
                new OutputView(),
                new TextFormatter()
        );
        controller.startRace();
    }
}
