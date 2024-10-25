package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.controller.RacingGameControllerImpl;
import racingcar.model.RacingGameModel;
import racingcar.model.RacingGameModelImpl;
import racingcar.view.RacingGameView;
import racingcar.view.RacingGameViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameModel model = new RacingGameModelImpl();
        RacingGameView view = new RacingGameViewImpl();

        RacingGameController controller = new RacingGameControllerImpl(model, view);

        controller.run();
    }
}
