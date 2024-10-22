package racingcar.domain;

import java.util.List;
import racingcar.randomnumber.RandomNumberGenerator;

public record Cars(
    List<Car> cars,
    RandomNumberGenerator randomNumberGenerator
) {
}
