package racingcar.dto.request;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.CarPosition;

import java.util.Arrays;
import java.util.List;

public record CarsRequest(
        String carNames
) {

    public static final String DELIMITER = ",";
    public static final int MINIMUM_NUMBER_OF_CARS = 2;

    public Cars toCars() {
        List<Car> cars = parseToName(carNames).stream()
                .map(name -> new Car(name, new CarPosition()))
                .toList();
        return new Cars(cars);

    }

    private List<CarName> parseToName(String carNames) {
        //TODO: parse메서드 위치 고민 및 콤마 상수 처리
        List<CarName> cars = Arrays.stream(carNames.split(DELIMITER))
                .map(String::strip)
                .filter(name -> !name.isBlank())
                .map(CarName::new)
                .toList();
        validateCarsSize(cars);
        return cars;
    }

    private void validateCarsSize(List<CarName> cars) {
        if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("최소 2명부터 경주가 가능합니다.");
        }
    }
}
