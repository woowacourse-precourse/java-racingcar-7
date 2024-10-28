package racingcar.model;

import java.util.HashSet;
import java.util.List;
import racingcar.constant.ExceptionMessage;

public class RaceTrack {
    private static final int INITIAL_POSITION = 0;

    private final RacePolicy racePolicy;
    private List<Car> cars;

    public RaceTrack(RacePolicy racePolicy) {
        this.racePolicy = racePolicy;
    }

    public void registerCars(List<String> carNames) {
        validateUniqueNames(carNames);
        this.cars = carNames.stream()
                .map(name -> new Car(racePolicy, name))
                .toList();
    }

    private void validateUniqueNames(List<String> carNames) {
        HashSet<String> uniqueCarNames = new HashSet<>(carNames);
        if (carNames.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAMES_DUPLICATE.getMessage());
        }
    }

    public void tryMoveAllCars() {
        for (Car car : cars) {
            car.tryMoveForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> determineWinners() {
        int farthestPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == farthestPosition)
                .toList();
    }
}
