package racingcar.domain.car;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

import java.util.*;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final String input) {
        validateInput(input);
        Arrays.stream(input.split(",")).forEach(user -> {
            cars.add(new Car(user));
        });
        validateDuplicateCarName();
    }

    private void validateDuplicateCarName() {
        Set<String> carsName = new HashSet<>();
        cars.forEach(car -> {
            if (isDuplicate(car, carsName)) {
                throw new BusinessException(RacingCarExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION);
            }
        });
    }

    private boolean isDuplicate(Car car, Set<String> carsName) {
        return !carsName.add(car.getName());
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_IS_NOT_NULL);
        }

        if (input.equals(",")) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_IS_NOT_NULL);
        }
    }

    public List<String> winners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
