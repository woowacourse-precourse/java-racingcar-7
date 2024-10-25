package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.global.ErrorMessage;

public record Cars(List<Car> carList) {
    private static final String CAR_NAME_DELIMITER = ",";

    public Cars(List<Car> carList) {
        validateDuplicateNames(carList);
        this.carList = List.copyOf(carList);
    }

    public static Cars of(String carNames, MovingStrategy movingStrategy) {
        List<Car> carList = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(each -> new Car(each, movingStrategy))
                .toList();
        return new Cars(carList);
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(each -> each.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_CARS_AVAILABLE.getMessage()));
    }

    private void validateDuplicateNames(List<Car> carList) {
        Set<String> uniqueNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (uniqueNames.size() != carList.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }
}