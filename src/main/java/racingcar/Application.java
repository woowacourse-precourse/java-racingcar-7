package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RaceController controller = new RaceController(new InputView());
        controller.run();
    }
}
