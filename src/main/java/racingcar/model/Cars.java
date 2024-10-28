package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
        validate();
    }

    public static Cars from(String input) {
        List<Car> cars = Arrays.stream(input.split(",", -1)).map(Car::from).toList();
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxLocation() {
        List<Integer> locations = cars.stream().map(Car::getCurrentLocation).toList();
        return Collections.max(locations);
    }

    private void validate() {
        validateCarsSize();
        validateDuplicate(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> checkCars = new HashSet<>(cars);
        if (checkCars.size() != cars.size()) {
            throw new IllegalArgumentException("게임 내 중복된 이름이 존재합니다.");
        }
    }

    private void validateCarsSize() {
        if (cars.size() <= 1 | cars.size() > 10) {
            throw new IllegalArgumentException("등록 가능한 자동차 이름은 최소 2개, 최대 10개입니다.");
        }
    }
}
