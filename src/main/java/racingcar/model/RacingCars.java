package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void race() {
        for (RacingCar car : cars) {
            int movementFactor = generateRandomMovementFactor();
            car.attemptMove(movementFactor);
        }
    }

    public List<RacingCar> getWinners() {
        int furthestPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(c -> c.isSamePosition(furthestPosition))
                .toList();
    }

    private int generateRandomMovementFactor() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
