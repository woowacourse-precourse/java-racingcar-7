package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.validator.BasicValidator;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfRoundsInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = racingCarController();
        racingCarController.run();
    }

    private static RacingCarController racingCarController() {
        return new RacingCarController(
                outputView(),
                inputView()
        );
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView(
                carNamesInputValidator(),
                numberOfRoundsInputValidator()
        );
    }

    private static BasicValidator<String> carNamesInputValidator() {
        return new CarNamesInputValidator();
    }

    private static BasicValidator<String> numberOfRoundsInputValidator() {
        return new NumberOfRoundsInputValidator();
    }
}
