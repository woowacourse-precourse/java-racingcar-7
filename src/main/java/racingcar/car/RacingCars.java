package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> cars;

    private RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public static RacingCars fromNames(List<String> carNames) {
        List<RacingCar> cars = carNames.stream()
                .map(RacingCar::of)
                .toList();
        return new RacingCars(cars);
    }

    public List<String> getWinnersName() {
        return new ArrayList<>(cars.stream()
                .filter(racingCar -> racingCar.isMoveCountEqualTo(getMaxMoveCount()))
                .map(RacingCar::getName)
                .toList());
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(RacingCar::getMoveCount)
                .max().orElseThrow(() -> new RuntimeException("최대값을 찾을 수 없습니다."));

    }
}
