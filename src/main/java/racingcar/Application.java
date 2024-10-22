package racingcar;

import racingcar.controller.CarController;
import racingcar.view.ConsoleInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarController controller =
                new CarController(new ConsoleInputView());
        controller.run();
    }
}
