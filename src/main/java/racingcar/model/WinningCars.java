package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCars {

    private static final String COMMA = ",";
    private final List<Car> cars;

    public WinningCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public String getWinnerNames() {
        return getWinnerList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));
    }

    private List<Car> getWinnerList() {
        return cars.stream()
                .filter(car -> car.hasSameMoveCount(getWinnerMoveCount()))
                .collect(Collectors.toList());
    }

    private int getWinnerMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

}
