package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        CarRacingController controller =
                new CarRacingController(new ConsoleInputView(), new ConsoleOutputView());
        controller.run();
    }
}
