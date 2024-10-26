package racingcar;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<CarName> carNames) {
        return new RacingCars(carNames.stream()
                .map(carName -> new RacingCar(carName, 0))
                .toList());
    }

    public void move(NumberGenerator numberGenerator) {
        racingCars.forEach(racingCar -> racingCar.move(numberGenerator.generate()));
    }

    public List<String> findWinners() {
        int maxLocation = getMaxLocationCars();
        return racingCars.stream()
                .filter(racingCar -> racingCar.isSameLocation(maxLocation))
                .map(RacingCar::getCarNameValue)
                .toList();
    }

    private int getMaxLocationCars() {
        return racingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대 위치인 자동차가 없습니다."));
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
