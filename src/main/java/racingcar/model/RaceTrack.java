package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class RaceTrack {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int INITIAL_POSITION = 0;

    private List<Car> cars;

    public void registerCars(String carRegistrationRequest) {
        List<String> carNames = Arrays.asList(carRegistrationRequest.split(CAR_NAME_SEPARATOR));
        validateUniqueNames(carNames);
        this.cars = carNames.stream().map(Car::new).toList();
    }

    private void validateUniqueNames(List<String> carNames) {
        long uniqueNamesSize = carNames.stream().distinct().count();
        if (uniqueNamesSize != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.tryMoveForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> determineWinners() {
        int farthestPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(INITIAL_POSITION);
        return cars.stream().filter(car -> car.getPosition() == farthestPosition).toList();
    }
}
