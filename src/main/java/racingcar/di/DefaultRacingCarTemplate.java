package racingcar.di;

import racingcar.model.dependency.RacingCarDependency;
import racingcar.model.dependency.moving_strategy.MovingStrategy;
import racingcar.model.dependency.moving_strategy.random.DefaultRandomMovingStrategy;
import racingcar.model.dependency.validator.DefaultRacingCarValidator;
import racingcar.model.dependency.validator.RacingCarValidator;
import racingcar.service.RacingService;
import racingcar.view.input.DefaultInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.DefaultOutputView;
import racingcar.view.output.OutputView;

public class DefaultRacingCarTemplate implements RacingCarTemplate {

    // View
    private final InputView inputView = new DefaultInputView();
    private final OutputView outputView = new DefaultOutputView();

    // Model
    private final RacingCarValidator racingCarValidator = new DefaultRacingCarValidator();
    private final MovingStrategy movingStrategy = new DefaultRandomMovingStrategy();
    private final RacingCarDependency racingCarDependency = new RacingCarDependency(racingCarValidator, movingStrategy);

    // Model - Service
    private final RacingService racingService = new RacingService(racingCarDependency);

    @Override
    public InputView inputView() {
        return inputView;
    }

    @Override
    public OutputView outputView() {
        return outputView;
    }

    @Override
    public RacingService racingService() {
        return racingService;
    }
}
