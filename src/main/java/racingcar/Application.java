package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new CarNameValidation(), new CountValidation());
        OutputView outputView = new OutputView();

        RacingGameController racingGameController = new RacingGameController(inputView, outputView);

        racingGameController.runGame();
    }
}
