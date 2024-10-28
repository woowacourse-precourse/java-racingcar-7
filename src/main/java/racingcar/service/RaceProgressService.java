package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.constant.Movement;
import racingcar.dto.CarLocation;
import racingcar.model.RacingCar;

public class RaceProgressService {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    public void moveCarsInRounds(List<RacingCar> cars) {
        cars.forEach(car -> {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            Movement movement = determineMovement(randomValue);
            car.move(movement);
        });
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
