package racingcar.model.domain;

import racingcar.common.exception.GameException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static racingcar.common.exception.ErrorCode.*;

public class CarList {

    private final List<Car> carList;

    private CarList(List<Car> carList) {
        validationCarList(carList);
        this.carList = carList;
    }

    private void validationCarList(List<Car> carList) {
        if (carList == null || carList.isEmpty()) {
            throw new GameException(NAMES_ERROR);
        }
    }

    public static CarList of(List<Car> carList) {
        return new CarList(carList);

    }

    public void add(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

    public int getFurthestPosition() {
        return this.carList
                .stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow()
                .getPosition();
    }
}