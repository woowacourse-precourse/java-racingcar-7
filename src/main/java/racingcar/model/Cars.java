package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorCode;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> carNames) {
        makeCarListWithNames(carNames);
    }

    private void makeCarListWithNames(final List<String> carNames) {

        carNames.stream()
                .peek(this::checkDuplicateCarName)
                .map(this::makeCar)
                .forEach(cars::add);
    }

    private void checkDuplicateCarName(final String carName) {

        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException(ErrorCode.CANT_INSERT_DUPLICATE_CAR_NAME.getMessage());
        }

    }

    private Car makeCar(String name) {
        return new Car(name);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getTopRankCarName(){

        int topMoveCount = getTop1MoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == topMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    private int getTop1MoveCount() {

        return   cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(()->new IllegalArgumentException(ErrorCode.CANT_FIND_MAX_MOVE_COUNT_IN_EMPTY.getMessage()));

    }


}
