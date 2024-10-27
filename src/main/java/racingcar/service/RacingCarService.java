package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarService {
    private final RacingCar racingCar;
    private List<RacingCar> racingCars;

    public RacingCarService(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    public void createRacingCars(String inputCarsName) {
        String[] carsNames = racingCar.splitCarsName(inputCarsName);
        this.racingCars = racingCar.createRacingCarsBySplitCarsName(carsNames);
    }
}
