package racingcar;

import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingModel model = new RacingModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(model, inputView, outputView);

        controller.run();
    }
}
