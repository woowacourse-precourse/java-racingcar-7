package racingcar.service;

import java.util.List;
import racingcar.model.Car;
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

    public List<Car> getWinner() {
        int maxPositionValue = racingCars.cars().stream()
                .mapToInt(Car::getPosition).max().orElse(0);

        return racingCars.cars().stream()
                .filter(car -> car.getPosition() == maxPositionValue)
                .toList();
    }
}
