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

public class Application {
    public static void main(String[] args) {
        MoveStrategy moveStrategy = new CarMoveStrategy();
        InputParser inputParser = new InputSplitter();
        Generator<Integer> generator = new IntegerGenerator();

        Validator<String> carNameValidator = new CarNameValidator();
        Validator<String> roundValidator = new RoundValidator();
        Validator<CarNames> carCountValidator = new CarCountValidator();
        ValidatorFacade validatorFacade = new ValidatorFacade(carNameValidator, roundValidator, carCountValidator);

        RacingService racingService = new RacingService(moveStrategy, generator);

        CarController carController = new CarController(racingService, validatorFacade, inputParser);

        carController.play();
    }
}
