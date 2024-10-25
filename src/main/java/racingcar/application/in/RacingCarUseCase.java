package racingcar.application.in;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public interface RacingCarUseCase {

    Racing startRacing(List<Car> cars, int tryCount) throws IllegalArgumentException;
}
