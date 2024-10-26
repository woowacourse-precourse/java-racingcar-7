package racingcar.properties.function;

import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;

@FunctionalInterface
public interface CarPositionPrinter {

    void print(LinkedHashSet<RacingCar> cars);
}
