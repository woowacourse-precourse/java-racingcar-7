package racingcar.application.in;

import java.util.List;
import racingcar.config.validation.annotation.Min;
import racingcar.config.validation.annotation.Valid;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public interface RacingCarUseCase {

    Racing startRacing(List<Car> cars, @Valid @Min(0) int tryCount);
}
