package racingcar.properties.function;

import racingcar.domain.RacingCar;

@FunctionalInterface
public interface CarNameFilter {

    boolean filter(RacingCar racingCar);
}
