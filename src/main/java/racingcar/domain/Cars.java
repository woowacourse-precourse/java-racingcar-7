package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String ERROR_MESSAGE_FOR_NUMBER_OF_CARS = "경주할 자동차가 부족합니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_FOR_DUPLICATED_CAR = "중복된 자동차 이름이 존재합니다. 프로그램을 종료합니다.";
    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        validate(cars);
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveEachCar() {
        cars.forEach(Car::move);
    }

    private static void validate(List<Car> cars) {
        validateNumberOfCars(cars);
        validateDuplicatedCar(cars);
    }

    private static void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NUMBER_OF_CARS);
        }
    }

    private static void validateDuplicatedCar(List<Car> cars) {
        if (afterSizeRemoveDuplication(cars) != cars.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DUPLICATED_CAR);
        }
    }

    private static int afterSizeRemoveDuplication(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .toList()
                .size();
    }
}
