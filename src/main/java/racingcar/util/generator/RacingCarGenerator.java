package racingcar.util.generator;

import java.util.List;
import racingcar.domain.RacingCar;

public interface RacingCarGenerator {
    public List<RacingCar> generateCar(List<String> carNames);
}
