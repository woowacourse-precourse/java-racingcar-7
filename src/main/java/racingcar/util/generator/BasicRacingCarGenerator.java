package racingcar.util.generator;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class BasicRacingCarGenerator implements RacingCarGenerator{
    @Override
    public List<RacingCar> generateCar(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }
}
