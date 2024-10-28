package racingcar;

import racingcar.controller.domain.RaceController;
import racingcar.controller.infrastructure.CarRaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController controller = new CarRaceController(new InputView(), new OutputView());
        controller.run();
    }
}
