package racingcar.service;

import java.util.List;
import racingcar.constant.Movement;
import racingcar.dto.CarLocation;
import racingcar.model.RacingCar;
import racingcar.model.RandomNumberGenerator;

public class RaceProgressService {
    private static final int FORWARD_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RaceProgressService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveCarsInRounds(List<RacingCar> cars) {
        cars.forEach(this::moveCar);
    }

    private void moveCar(RacingCar car) {
        int randomValue = randomNumberGenerator.generate();
        Movement movement = determineMovement(randomValue);
        car.move(movement);
    }

    public List<CarLocation> getCurrentLocations(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> new CarLocation(car.getName(), car.getLocation()))
                .toList();
    }

    private Movement determineMovement(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            return Movement.MOVING_FORWARD;
        } else {
            return Movement.STOP;
        }
    }
}
