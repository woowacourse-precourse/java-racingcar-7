package racingcar.domain;

import java.util.List;

public class Cars {
    private static final String ERROR_MESSAGE_FOR_NUMBER_OF_CARS = "경주할 자동차가 부족합니다. 프로그램을 종료합니다.";

    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }
    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private static void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NUMBER_OF_CARS);
        }
    }
}
