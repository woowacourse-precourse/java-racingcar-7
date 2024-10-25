package racingcar.dto.request;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

import java.util.List;

public record CarsRequest(
        List<CarName> cars
) {
    public static final int MINIMUM_NUMBER_OF_CARS = 2;
    public static final int MAXIMUM_NUMBER_OF_CARS = 10;

    public CarsRequest {
        validateCarsSize(cars);
        validateDuplicatedName(cars);
    }

    public Cars toCars() {
        return new Cars(
                cars.stream()
                        .map(name -> new Car(name, new CarPosition()))
                        .toList()
        );
    }

    private void validateCarsSize(List<CarName> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS || cars.size() > MAXIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("최소 2명부터 최대 10명까지 경주가 가능합니다.");
        }
    }

    private void validateDuplicatedName(List<CarName> cars) {
        if (hasDuplicateNames(cars)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    private boolean hasDuplicateNames(List<CarName> cars) {
        return cars.size() != cars.stream().distinct().count();
    }
}
