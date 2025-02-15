package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView view = new RacingCarView();
        RacingCarController controller = new RacingCarController(view);
        controller.run();
    }
}