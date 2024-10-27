package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateDuplicateRacingCarNames(racingCars);
        this.racingCars = racingCars;
    }

    private void validateDuplicateRacingCarNames(List<RacingCar> racingCars) {
        Set<RacingCarName> racingCarNames = racingCars.stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toSet());

        if (racingCarNames.size() != racingCars.size()) {
            throw new IllegalArgumentException("자동차 이름을 중복으로 사용할 수 없습니다.");
        }
    }
}
