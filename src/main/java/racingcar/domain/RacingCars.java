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
}
