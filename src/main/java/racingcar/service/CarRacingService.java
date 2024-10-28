package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.DriveStrategy;

public class CarRacingService {

    private final DriveStrategy driveStrategy;

    public CarRacingService(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public Cars race(Cars racingCars) {
        racingCars.cars().forEach(car -> car.drive(driveStrategy));
        return racingCars;
    }

    public List<Car> getWinner(Cars racingCars) {
        int maxPositionValue = racingCars.cars().stream()
                .mapToInt(Car::getPosition).max().orElse(0);

        return racingCars.cars().stream()
                .filter(car -> car.getPosition() == maxPositionValue)
                .toList();
    }
}
