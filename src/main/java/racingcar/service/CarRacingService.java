package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.DriveStrategy;

public class CarRacingService {

    private final Cars racingCars;
    private final DriveStrategy driveStrategy;

    public CarRacingService(Cars racingCars, DriveStrategy driveStrategy) {
        this.racingCars = racingCars;
        this.driveStrategy = driveStrategy;
    }

    public void race() {
        racingCars.cars().forEach(car -> car.drive(driveStrategy));
    }
}
