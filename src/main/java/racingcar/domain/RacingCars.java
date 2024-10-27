package racingcar.domain;

import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        this.racingCars = carNames.stream()
                .map(RacingCar::new)
                .toList();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getFinalWinners() {
        int maxMoveDistance = racingCars.stream()
                .mapToInt(RacingCar::getMoveDistance)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .toList();
    }
}
