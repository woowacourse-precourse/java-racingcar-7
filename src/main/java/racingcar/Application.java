package racingcar;

import racingcar.controller.domain.GameController;
import racingcar.controller.infrastructure.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = new RaceController(new InputView(), new OutputView());
        controller.run();
    }
}
