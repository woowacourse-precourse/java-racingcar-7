package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.InputParser;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        RacingModel model = new RacingModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(parser, model, inputView, outputView);

        controller.race();
    }
}
