package racingcar;

import racingcar.controller.CarController;
import racingcar.model.CarNames;
import racingcar.service.RacingService;
import racingcar.strategy.CarMoveStrategy;
import racingcar.strategy.MoveStrategy;
import racingcar.util.generator.Generator;
import racingcar.util.generator.IntegerGenerator;
import racingcar.util.parser.InputParser;
import racingcar.util.parser.InputSplitter;
import racingcar.validator.CarCountValidator;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;
import racingcar.validator.Validator;
import racingcar.validator.ValidatorFacade;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewFacade;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputSplitter();

        MoveStrategy moveStrategy = new CarMoveStrategy();
        Generator<Integer> generator = new IntegerGenerator();
        RacingService racingService = new RacingService(moveStrategy, generator);

        Validator<String> carNameValidator = new CarNameValidator();
        Validator<String> roundValidator = new RoundValidator();
        Validator<CarNames> carCountValidator = new CarCountValidator();
        ValidatorFacade validatorFacade = new ValidatorFacade(carNameValidator, roundValidator, carCountValidator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ViewFacade viewFacade = new ViewFacade(inputView, outputView);

        CarController carController = new CarController(racingService, validatorFacade, inputParser, viewFacade);

        carController.play();
    }
}
