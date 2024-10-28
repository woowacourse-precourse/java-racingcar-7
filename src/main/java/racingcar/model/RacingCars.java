package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {

    private static final int MIN_NUMBER_OF_CARS = 2;
    private static final int MAX_NUMBER_OF_CARS = 40;

    private final List<RacingCar> cars;
    private final MovementFactorGenerator movementFactorGenerator;

    public RacingCars(List<RacingCar> cars, MovementFactorGenerator movementFactorGenerator) {
        validateSize(cars);
        validateNoDuplicates(cars);
        this.movementFactorGenerator = movementFactorGenerator;
        this.cars = cars;
    }

    public static RacingCars of(List<String> names, MovementFactorGenerator movementFactorGenerator) {
        List<RacingCar> cars = names.stream()
                .map(RacingCar::new)
                .toList();
        return new RacingCars(cars, movementFactorGenerator);
    }

    public List<RacingCarSnapShot> race() {
        for (RacingCar car : cars) {
            int movementFactor = movementFactorGenerator.generate();
            car.attemptMove(movementFactor);
        }
        return getCarSnapShots();
    }

    public List<String> getWinners() {
        int furthestPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(c -> c.isSamePosition(furthestPosition))
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private void validateSize(List<RacingCar> cars) {
        if (isOutOfRange(cars)) {
            String message = String.format("경주할 자동차의 대수는 %d~%d 사이어야 합니다.", MIN_NUMBER_OF_CARS, MAX_NUMBER_OF_CARS);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isOutOfRange(List<RacingCar> cars) {
        return cars.size() < MIN_NUMBER_OF_CARS || cars.size() > MAX_NUMBER_OF_CARS;
    }

    private void validateNoDuplicates(List<RacingCar> cars) {
        if (hasDuplicateName(cars)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicateName(List<RacingCar> cars) {
        Set<String> distinctNames = new HashSet<>();
        return cars.stream()
                .anyMatch(name -> !distinctNames.add(name.getName()));
    }

    private List<RacingCarSnapShot> getCarSnapShots() {
        return cars.stream()
                .map(RacingCar::getSnapshot)
                .toList();
    }

}
