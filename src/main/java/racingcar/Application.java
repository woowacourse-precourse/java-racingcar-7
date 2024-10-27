package racingcar;

import java.math.BigInteger;
import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.model.Parser;
import racingcar.model.Validator;
import racingcar.model.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        Validator validator = new Validator();

        InputController inputController = new InputController(inputView, parser, validator);
        RaceController raceController = new RaceController(outputView, parser);

        run(inputController, raceController);
    }

    private static void run(InputController inputController, RaceController raceController) {
        Cars cars = inputController.getValidatedCarNames();
        BigInteger attemptCount = inputController.getValidatedAttemptCount();
        raceController.runRace(cars, attemptCount);
    }
}
