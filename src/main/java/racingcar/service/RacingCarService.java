package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarService {

    List<RacingCar> racingCars;

    public RacingCarService() {
    }

    public void setupRaceCars(List<String> racingCarNames) {
        racingCars = racingCarNames.stream().map(RacingCar::new).toList();
    }

    public void runRound() {
        racingCars.forEach(RacingCar::move);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
