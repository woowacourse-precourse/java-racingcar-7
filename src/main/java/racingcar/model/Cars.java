package racingcar.model;

import java.util.List;
import racingcar.constants.Constants;
import racingcar.constants.ErrorMessages;
import racingcar.utils.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final StringBuilder gameResult = new StringBuilder();

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    public List<CarName> getFinalWinners() {
        return this.cars.stream()
                .filter(car -> car.getDistance() == findMaxDistance())
                .map(Car::getCarName)
                .toList();
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.decideToGo(RandomNumberGenerator.getRandomNumber());
        }
        saveGameResult();
    }

    public String getGameResult() {
        return gameResult.toString();
    }

    private void saveGameResult() {
        for (Car car : cars) {
            gameResult.append(car.getCurrentState());
            gameResult.append(Constants.ENTER);
        }
        gameResult.append(Constants.ENTER);
    }

    private int findMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    private void validateCars(List<Car> cars) {
        validateEmpty(cars);
        validateDuplication(cars);
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK.getMessage());
        }
    }

    private void validateDuplication(List<Car> cars) {
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(List<Car> cars) {
        return cars.size() != cars.stream().distinct().count();
    }
}
