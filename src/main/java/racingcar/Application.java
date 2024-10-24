package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController controller = new RaceController(new InputView(), new OutputView(), new RaceService());
        controller.run();
    }
}
