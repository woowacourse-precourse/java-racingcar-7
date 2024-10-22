package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import racingcar.controller.RacingCarController;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.run();
    }
}
