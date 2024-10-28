package racingcar.model;

import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(List<String> racingCarNames) {
        for (String name : racingCarNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
