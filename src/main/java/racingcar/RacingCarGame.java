package racingcar;

import java.util.List;

public class RacingCarGame {

    public int getMaxLocationCars(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getLocation)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치인 자동차가 없습니다."));
    }
}
