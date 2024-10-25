package racingcar.service;

import java.util.List;
import racingcar.context.RacingCar;
import racingcar.strategy.MovementStrategy;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<String> racingCarNames) {
        this.racingCars = createCarNameToRacingCar(racingCarNames);
    }

    private List<RacingCar> createCarNameToRacingCar(List<String> racingCarNames) {
        return racingCarNames
                .stream()
                .map(x -> new RacingCar(x.trim(), new MovementStrategy()))
                .toList();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
