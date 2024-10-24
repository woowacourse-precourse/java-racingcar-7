package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfRoundsInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(
                new InputView(
                        new CarNamesInputValidator(),
                        new NumberOfRoundsInputValidator()
                ),
                new OutputView()
        );

        racingCarController.run();
    }
}
