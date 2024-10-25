package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        validateNoDuplicates(cars);
        this.cars = cars;
    }

    public static RacingCars of(List<String> names) {
        List<RacingCar> cars = names.stream()
                .map(RacingCar::new)
                .toList();
        return new RacingCars(cars);
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

    public List<RacingCarSnapShot> getCarSnapShots() {
        return cars.stream()
                .map(RacingCar::getSnapshot)
                .toList();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private void validateNoDuplicates(List<RacingCar> cars) {
        Set<String> distinctNames = new HashSet<>();
        for (RacingCar car : cars) {
            if (!distinctNames.add(car.getName())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    private int generateRandomMovementFactor() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
