package racingcar.config;

import java.util.List;
import racingcar.domain.mover.AllCarMover;
import racingcar.domain.mover.CarMover;
import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.domain.winnerdecider.policy.MaxMoveWinningPolicy;
import racingcar.domain.mover.policy.MovePolicy;
import racingcar.view.OutputView;
import racingcar.domain.mover.policy.RandomMovePolicy;
import racingcar.domain.mover.policy.trigger.RandomNumberGenerator;
import racingcar.domain.winnerdecider.WinnersDecider;
import racingcar.domain.winnerdecider.policy.WinningPolicy;
import racingcar.argumentresolver.ArgumentResolver;
import racingcar.argumentresolver.AttemptCountArgumentResolver;
import racingcar.argumentresolver.CarArgumentResolver;
import racingcar.validator.RangeValidator;
import racingcar.validator.SizeValidator;
import racingcar.validator.Validator;

public class ControllerConfig {

    public Controller controller() {
        return new Controller(
                outputView(),
                inputView(),
                carArgumentResolver(),
                attemptCountArgumentResolver(),
                sizeValidator(),
                rangeValidator(),
                allCarMover(),
                winnersDecider()
        );
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }

    public ArgumentResolver<List<String>> carArgumentResolver() {
        return new CarArgumentResolver();
    }

    public ArgumentResolver<Integer> attemptCountArgumentResolver() {
        return new AttemptCountArgumentResolver();
    }

    public Validator<List<String>> sizeValidator() {
        return new SizeValidator();
    }

    public Validator<Integer> rangeValidator() {
        return new RangeValidator();
    }

    public AllCarMover allCarMover() {
        return new AllCarMover(carMover());
    }

    public CarMover carMover() {
        return new CarMover(movePolicy());
    }

    public MovePolicy movePolicy() {
        return new RandomMovePolicy(randomNumberGenerator());
    }

    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public WinnersDecider winnersDecider() {
        return new WinnersDecider(winningPolicy());
    }

    public WinningPolicy winningPolicy() {
        return new MaxMoveWinningPolicy();
    }

}
