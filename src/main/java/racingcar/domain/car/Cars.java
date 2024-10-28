package racingcar.domain.car;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

import java.util.*;

public class Cars implements Iterable<Car> {

    public static final String DELIMITER = ",";
    public static final int DEFAULT_POSITION = 0;

    private final List<Car> cars = new ArrayList<>();

    public Cars(final String input) {
        Set<String> carsName = new HashSet<>();
        validateInput(input);
        Arrays.stream(input.split(DELIMITER)).forEach(user -> {
            if (!carsName.add(user)) {
                throw new BusinessException(RacingCarExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION);
            }
            cars.add(new Car(user));
        });
    }

    private void validateInput(String input) {
        if (isEmpty(input) || isDelimiter(input)) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_IS_NOT_NULL);
        }
    }

    public List<String> winners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    private boolean isDelimiter(final String input) {
        return input.trim().equals(DELIMITER);
    }

    private boolean isEmpty(final String input) {
        return input.trim().isEmpty();
    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }
}
