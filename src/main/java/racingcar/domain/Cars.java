package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Cars {

    private static final String SPLIT_DELIMITER = ",";
    private static final String DUPLICATE_CAR_NAME = "중복된 이름이 존재합니다.";


    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Cars(String carName, MoveStrategy moveStrategy) {
        this.cars = createCars(carName);
        this.moveStrategy = moveStrategy;
        validateDuplicateCarNames();
    }

    public void moveAllCars() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> createCars(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        List<Car> cars = new ArrayList<>();

        for (String name : splitCarNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private String[] splitCarNames(final String carNames) {
        return carNames.split(SPLIT_DELIMITER);
    }

    private void validateDuplicateCarNames() {
        int uniqueCarNames = new HashSet<>(cars).size();

        if (uniqueCarNames != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
