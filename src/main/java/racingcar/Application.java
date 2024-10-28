package racingcar;

import racingcar.controller.CarRacingGameController;
import racingcar.model.CarRacingGameConfig;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRacingGameConfig gameConfig = new CarRacingGameConfig();
        CarRacingGameController controller = new CarRacingGameController(inputView, outputView, gameConfig);
        controller.execute();
    }
}
