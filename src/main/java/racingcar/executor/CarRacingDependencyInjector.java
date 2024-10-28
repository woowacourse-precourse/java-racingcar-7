package racingcar.executor;

import racingcar.executor.mover.AllCarMoverImpl;
import racingcar.executor.decider.movement.RandomMovementDeciderImpl;
import racingcar.executor.decider.winner.WinnerListDeciderImpl;
import racingcar.extractor.car.name.CarNameExtractorImpl;
import racingcar.input.car.name.ConsoleCarNameInput;
import racingcar.input.trial.ConsoleMoveTrialInput;
import racingcar.output.process.ProcessOutputHandlerImpl;
import racingcar.output.result.ResultOutputHandlerImpl;
import racingcar.validator.car.name.CarNameValidatorImpl;
import racingcar.validator.car.name.count.CarNameCountValidatorImpl;
import racingcar.validator.car.name.length.CarNameLengthValidatorImpl;
import racingcar.validator.trial.MoveTrialValidatorImpl;

public class CarRacingDependencyInjector {
    public CarRacingExecutor createCarRacingExecutor() {
        CarNameExtractorImpl carNameExtractor = new CarNameExtractorImpl();
        CarNameCountValidatorImpl carNameCountValidator = new CarNameCountValidatorImpl();
        CarNameLengthValidatorImpl carNameLengthValidator = new CarNameLengthValidatorImpl();
        CarNameValidatorImpl carNameValidator = new CarNameValidatorImpl(carNameExtractor, carNameLengthValidator, carNameCountValidator);
        ConsoleCarNameInput consoleCarNameInput = new ConsoleCarNameInput(carNameValidator);

        MoveTrialValidatorImpl moveTrialValidator = new MoveTrialValidatorImpl();
        ConsoleMoveTrialInput consoleMoveTrialInput = new ConsoleMoveTrialInput(moveTrialValidator);

        RandomMovementDeciderImpl randomMovementDecider = new RandomMovementDeciderImpl();
        AllCarMoverImpl moveDistanceCalculator = new AllCarMoverImpl(randomMovementDecider);

        ProcessOutputHandlerImpl processOutputHandler = new ProcessOutputHandlerImpl();

        WinnerListDeciderImpl winnerListDecider = new WinnerListDeciderImpl();
        ResultOutputHandlerImpl resultOutputHandler = new ResultOutputHandlerImpl(winnerListDecider);

        return new CarRacingExecutor(
                consoleCarNameInput,
                carNameExtractor,
                moveDistanceCalculator,
                consoleMoveTrialInput,
                processOutputHandler,
                resultOutputHandler
        );
    }

}
