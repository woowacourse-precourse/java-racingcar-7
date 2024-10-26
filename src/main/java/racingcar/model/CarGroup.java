package racingcar.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

public class CarGroup {

    private static final String ERROR_MIN_CARS_MESSAGE = "자동차 이름은 적어도 두 개 입력해야 합니다.";
    private static final String ERROR_DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    private static final int MIN_CARS_SIZE = 2;

    private final Set<Car> cars;

    public CarGroup(List<String> carNames) {
        this.cars = initCars(carNames);
        validateSize();
    }

    private Set<Car> initCars(List<String> carNames) {
        Set<Car> cars = carNames.stream().map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        validateDuplicateCarName(carNames.size(), cars.size());
        return cars;
    }

    private void validateDuplicateCarName(int originalSize, int uniqueSize) {
        if (originalSize != uniqueSize) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private void validateSize() {
        if (this.cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException(ERROR_MIN_CARS_MESSAGE);
        }
    }

    public Set<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream().filter(car -> car.getPosition().equals(maxPosition)).toList();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public void move() {
        cars.forEach(car -> {
            car.moveFront(RandomNumberGenerator.generate());
        });
    }
}
