package racingcar;

import racingcar.controller.CarController;
import racingcar.generator.Generator;
import racingcar.generator.IntegerGenerator;
import racingcar.model.CarNames;
import racingcar.service.RacingService;
import racingcar.strategy.CarMoveStrategy;
import racingcar.strategy.MoveStrategy;
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

        CarController carController = new CarController(racingService, validatorFacade, viewFacade);

        carController.play();
    }
}
