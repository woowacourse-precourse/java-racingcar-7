package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        this.racingCars = carNames.stream()
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> findWinners() {
        int maxMoves = racingCars.stream()
            .mapToInt(RacingCar::getMoves)
            .max()
            .orElse(0);

        return racingCars.stream()
            .filter(car -> car.isAt(maxMoves))
            .collect(Collectors.toList());
    }
}
