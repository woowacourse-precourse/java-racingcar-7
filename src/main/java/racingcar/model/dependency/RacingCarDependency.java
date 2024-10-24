package racingcar.model.dependency;

import racingcar.model.dependency.moving_strategy.MovingStrategy;
import racingcar.model.dependency.validator.RacingCarValidator;

public record RacingCarDependency
        (RacingCarValidator racingCarValidator,
         MovingStrategy movingStrategy) {
}
