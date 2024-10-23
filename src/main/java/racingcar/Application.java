package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarRacingController controller =
                new CarRacingController(new ConsoleInputView(), new ConsoleOutputView());
        controller.run();
    }
}
